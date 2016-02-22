package com.eboji.center.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eboji.model.constant.Constant;

public class CenterServerHandler extends SimpleChannelInboundHandler<String> {
	private static final Logger logger = LoggerFactory.getLogger(CenterServerHandler.class);
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		CenterServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		//读取请求的类型直接转发至各特定的服务进行处理
		//1. msg解析为JSON对象
		try {
			JSONObject obj = JSON.parseObject(msg);
			String type = obj.getString(Constant.KEY_TYPE);
			String gid = obj.getString(Constant.KEY_GID);
			String cid = obj.getString(Constant.KEY_CID);
			
			//根据type,gid进行转发
			logger.info("type = " + type);
			logger.info("gid = " + gid);
			logger.info("cid = " + cid);
			
			CenterServerClientMap.put(cid, (SocketChannel)ctx.channel());
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
