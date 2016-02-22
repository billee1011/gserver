package com.eboji.login.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.ConnResMsg;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.LoginResMsg;

public class LoginServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(LoginServerHandler.class);
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		LoginServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		try {
			if(MsgType.LOGIN.equals(msg.getT())) {
				LoginMsg loginMsg = (LoginMsg)msg;
				LoginResMsg loginResMsg = new LoginResMsg();
				loginResMsg.setCid(loginMsg.getCid());
				if("robin".equals(loginMsg.getUsername()) && "robin".equals(loginMsg.getPassword())) {
					LoginServerClientMap.put(loginMsg.getCid(), (SocketChannel)ctx.channel());
					
					logger.info("client " + loginMsg.getCid() + " Login SUCCESS!");
					
					loginResMsg.setStatus("OK");
				} else {
					loginResMsg.setStatus("FAIL");
				}
				
				ctx.channel().writeAndFlush(loginResMsg);
			} else if(MsgType.CONN.equals(msg.getT())) {
				ConnResMsg connResMsg = new ConnResMsg();
				connResMsg.setStatus("OK");
				
				ctx.channel().writeAndFlush(connResMsg);
				
			} else if(MsgType.PING.equals(msg.getT())) {
				logger.info("client " + msg.getT() + " SUCCESS!");
				
				ConnResMsg connResMsg = new ConnResMsg();
				connResMsg.setStatus("OK");
				
				ctx.channel().writeAndFlush(connResMsg);
			} else {
				if(LoginServerClientMap.get(msg.getCid()) == null) {
					LoginMsg loginMsg = new LoginMsg();
					ctx.channel().writeAndFlush(loginMsg);
				}
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
