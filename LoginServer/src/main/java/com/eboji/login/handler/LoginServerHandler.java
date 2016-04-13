package com.eboji.login.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.ConnResMsg;
import com.eboji.model.message.LoginMsg;

public class LoginServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(LoginServerHandler.class);
	
	protected MemCacheClient memCacheClient = null;
	
	protected LoginServerProcessor processor = null;
	
	public LoginServerHandler(MemCacheClient memCacheClient) {
		this.memCacheClient = memCacheClient;
		this.processor = new LoginServerProcessor();
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		LoginServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String clientId = ctx.channel().remoteAddress().toString();
		LoginServerClientMap.put(clientId, (SocketChannel)ctx.channel());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		try {
			MsgType t = msg.getT();
			ConnResMsg connResMsg = null;
			switch (t) {
			case CONN:
				connResMsg = new ConnResMsg();
				connResMsg.setStatus("OK");
				ctx.channel().writeAndFlush(connResMsg);
				break;
			case PING:
				logger.debug("client " + msg.getT() + " SUCCESS!");
				connResMsg = new ConnResMsg();
				connResMsg.setStatus("OK");
				ctx.channel().writeAndFlush(connResMsg);
				break;
			case LOGIN:
				LoginMsg loginMsg = (LoginMsg)msg;
				processor.process(loginMsg, ctx.channel().remoteAddress().toString());
				break;

			default:
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
