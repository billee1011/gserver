package com.eboji.center.transfer.tcp.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eboji.center.util.ConfigUtil;
import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.ConnMsg;

public class AgentRegClientHandler extends SimpleChannelInboundHandler<String> {
	private static final Logger logger = LoggerFactory.getLogger(AgentRegClientHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ConnMsg conn = new ConnMsg();
		conn.setCid(ConfigUtil.getProps("serverid"));
		
		ctx.writeAndFlush(conn);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().remoteAddress() + "请求客户端已断开!");
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		JSONObject obj = JSON.parseObject(msg);
		String type = obj.getString(Constant.KEY_TYPE);
		String gid = obj.getString(Constant.KEY_GID);
		
		//根据type,gid进行转发
		logger.info("type = " + type);
		logger.info("gid = " + gid);
		
		if(MsgType.REGRES.equals(MsgType.valueOf(type))) {
			if(Constant.STATUS_SUCCESS.equals(obj.getString("status"))) {
				ctx.close();
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.info("remote address: " + ctx.channel().remoteAddress() + ", " + cause.getMessage());
	}
}
