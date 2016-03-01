package com.eboji.game.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class GameServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(GameServerHandler.class);
	
	protected MemCacheClient memCacheClient = null;
	
	protected GameServerProcessor processor = null;
	
	public GameServerHandler(MemCacheClient memCacheClient) {
		this.memCacheClient = memCacheClient;
		if(this.memCacheClient == null) {
			logger.error("memCacheClient is null, server will be stopped.");
			System.exit(-1);
		}
		
		processor = new GameServerProcessor();
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		GameServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String clientId = ctx.channel().remoteAddress().toString();
		GameServerClientMap.put(clientId, (SocketChannel)ctx.channel());
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		try {
			MsgType type = msg.getT();
			switch (type) {
			case CONN:
			case PING:
			case REG:
				logger.info("client " + msg.getT() + " SUCCESS!");
				break;
			default:
				//处理游戏逻辑
				processor.process(memCacheClient, msg, 
					ctx.channel().remoteAddress().toString());
				break;
			}
		} catch (Exception e) {
			logger.error("request param is not json object, request msg is:\n" + msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.info("remote address: " + ctx.channel().remoteAddress() + ", " + cause.getMessage()); 
	}
}
