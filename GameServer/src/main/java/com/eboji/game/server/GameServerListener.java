package com.eboji.game.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.game.codec.MsgDecoder;
import com.eboji.game.codec.MsgEncoder;
import com.eboji.game.handler.GameServerHandler;
import com.eboji.game.util.RegisterCenterServerUtil;

public class GameServerListener {
	private static final Logger logger = LoggerFactory.getLogger(GameServerListener.class);
	
	private int port;
	
	private MemCacheClient memCacheClient;
	
	public GameServerListener(int port, MemCacheClient memCacheClient) throws Exception {
		this.port = port;
		this.memCacheClient = memCacheClient;
		
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
					pipe.addLast(new GameServerHandler(memCacheClient));
				}
			});
			
			ChannelFuture f = bootstrap.bind(port).sync();
			if(f.isSuccess()) {
				logger.info("Login Server listened in port " + this.port + " started.");
				
				RegisterCenterServerUtil.registerService();
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