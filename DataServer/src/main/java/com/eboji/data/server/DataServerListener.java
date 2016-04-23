package com.eboji.data.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.Constant;
import com.eboji.commons.codec.MsgDecoder;
import com.eboji.commons.codec.MsgEncoder;
import com.eboji.commons.hook.ConnectionFactory;
import com.eboji.data.bootstrap.Daemon;
import com.eboji.data.server.transfer.TransferHandler;
import com.eboji.data.server.transfer.TransferProcessor;
import com.eboji.data.service.DataService;
import com.eboji.data.util.ConfigUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DataServerListener {
	private static final Logger logger = LoggerFactory.getLogger(DataServerListener.class);
	
	private int port;
	
	private int poolSize;
	
	private DataService dataService = null;
	
	public DataServerListener(int port, int poolSize,
			DataService dataService) throws Exception {
		this.port = port;
		this.poolSize = poolSize;
		this.dataService = dataService;
		
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
					pipe.addLast(new MsgEncoder());
					pipe.addLast(new MsgDecoder());
					pipe.addLast(new DataServerHandler(poolSize, dataService));
				}
			});
			
			ChannelFuture f = bootstrap.bind(port).sync();
			if(f.isSuccess()) {
				logger.info("Login Server listened in port: " + this.port + " has been started.");
				
				ConnectionFactory.registerServiceToCenterServer(ConfigUtil.getProps("centerserver"), 
						new TransferHandler() , Daemon.getInstance().getPort(), 
						TransferProcessor.getSocketChannelMap(), 
						TransferProcessor.getServiceMap(), Constant.SRV_DATA);
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
