package com.eboji.center.transfer.tcp.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.center.util.ConfigUtil;
import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.ConnMsg;
import com.eboji.model.message.RegisterResMsg;

public class RegClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(RegClientHandler.class);
	
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
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		MsgType msgType = msg.getT();
		switch (msgType) {
		case REGRES:
			RegisterResMsg regResMsg = (RegisterResMsg)msg;
			if(Constant.STATUS_SUCCESS.equals(regResMsg.getStatus())) {
				ctx.close();
			}
			
			break;
		default:
			break;
		}
		
		ReferenceCountUtil.release(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.info("remote address: " + ctx.channel().remoteAddress() + ", " + cause.getMessage());
	}
}
