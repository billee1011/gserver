package com.eboji.agent.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.agent.bootstrap.Daemon;
import com.eboji.agent.codec.AgentDecoder;
import com.eboji.agent.codec.AgentEncoder;
import com.eboji.agent.servlet.ServiceServlet;
import com.eboji.agent.transfer.TransferHandler;
import com.eboji.agent.transfer.TransferProcessor;
import com.eboji.agent.util.ConfigUtil;
import com.eboji.commons.Constant;
import com.eboji.commons.hook.ConnectionFactory;
import com.eboji.commons.jetty.JettyServerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class AgentServerListener {
	private static final Logger logger = LoggerFactory.getLogger(AgentServerListener.class);
	
	private int port;
	
	public AgentServerListener(int port) throws Exception {
		this.port = port;
		bind();
	}
	
	protected void bind() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workerGroup);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.option(ChannelOption.SO_BACKLOG, 128);
			bootstrap.option(ChannelOption.TCP_NODELAY, true);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			
			bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipe = ch.pipeline();
					pipe.addLast(new AgentEncoder());
					pipe.addLast(new AgentDecoder());
					pipe.addLast(new AgentServerHandler());
				}
			});
			
			ChannelFuture f = bootstrap.bind(port).sync();
			if(f.isSuccess()) {
				logger.info("AgentServer listened on port: " + this.port + " has been started.");
				
				ConnectionFactory.registerServiceToCenterServer(ConfigUtil.getProps("centerserver"), 
						new TransferHandler() , Daemon.getInstance().getPort(), 
						TransferProcessor.getSocketChannelMap(), 
						TransferProcessor.getServiceMap(), Constant.SRV_AGENT);
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							JettyServerFactory.getInstance()
								.port(Daemon.getInstance().getPort() + 10000)
								.addServlet(new ServiceServlet())
								.build().start();
						} catch (Exception e) {
							logger.warn("jetty server start failed!");
						}
					}
				}).start();
				
			}
			
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			throw e;
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
