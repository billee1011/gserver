package com.eboji.center.transfer.tcp.connection;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.center.codec.MsgDecoder;
import com.eboji.center.codec.MsgEncoder;
import com.eboji.center.transfer.tcp.handler.RegClientHandler;

public class RegClientConnection {
	private static final Logger logger = LoggerFactory.getLogger(RegClientConnection.class);
	
	private int port;
	private String host;
	private SocketChannel socketChannel;

	public RegClientConnection(int port, String host) {
		this.port = port;
		this.host = host;
		
		start();
	}
	
	private void start() {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_BACKLOG, 128);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipe = ch.pipeline();
					pipe.addLast(new IdleStateHandler(20, 10, 0));
					pipe.addLast(new MsgEncoder());
					pipe.addLast(new MsgDecoder());
					pipe.addLast(new RegClientHandler());
				}
			});
			
			ChannelFuture future =bootstrap.connect(host,port).sync();
	        if (future.isSuccess()) {
	            socketChannel = (SocketChannel)future.channel();
	            logger.info("Connect login server [" + host + ":" + port + "] success");
	        }
	        
//	        future.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			workerGroup.shutdownGracefully();
		}
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public SocketChannel getSocketChannel() {
		return socketChannel;
	}

	public void setSocketChannel(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
}
