package com.eboji.im.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.ConnResMsg;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.LoginResMsg;

public class IMServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(IMServerHandler.class);
	
	protected MemCacheClient memCacheClient = null;
	
	public IMServerHandler(MemCacheClient memCacheClient) {
		this.memCacheClient = memCacheClient;
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		IMServerClientMap.remove((SocketChannel)ctx.channel());
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
					logger.info("client " + loginMsg.getCid() + " Login SUCCESS!");
					loginResMsg.setUid(String.valueOf(new Random(System.currentTimeMillis()).nextInt(9999)));
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
			} else if(MsgType.REG.equals(msg.getT())) { 
				//TODO
			} else {
				if(IMServerClientMap.get(msg.getCid()) == null) {
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
