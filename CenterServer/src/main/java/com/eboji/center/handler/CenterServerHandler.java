package com.eboji.center.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.center.transfer.tcp.RegClientTransfer;
import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.RegisterMsg;

public class CenterServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(CenterServerHandler.class);
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		CenterServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		try {
			MsgType type = msg.getT();
			switch (type) {
			case PING:
				logger.info("receive ping from client[" + ctx.channel().remoteAddress() + "]");
				
				break;
			case REG:
				RegisterMsg regMsg = (RegisterMsg)msg;
				
				String remote = ctx.channel().remoteAddress().toString();
				String remoteIP = remote.substring(1, remote.indexOf(Constant.STR_COLON));
				String address = remoteIP + Constant.STR_COLON + regMsg.getCport();
				
				logger.info(regMsg.getServerId() + "[" + remote + "]向中心服务注册成功!");
				
				RegClientTransfer.getSocketChannelMap().get(address).close();
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
