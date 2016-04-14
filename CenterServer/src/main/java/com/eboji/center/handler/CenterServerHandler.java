package com.eboji.center.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleState;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.PingMsg;
import com.eboji.model.message.RegisterMsg;
import com.eboji.model.message.RegisterResMsg;

/**
 * CenterServer的处理类
 * @author zhoucl 2016-02-29
 *
 */
public class CenterServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(CenterServerHandler.class);
	
	/**
	 * 客户端连接断开响应,删除对应的存储信息
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		CenterServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	/**
	 * 接收客户端消息的处理函数
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		try {
			MsgType type = msg.getT();
			switch (type) {
			//客户端空闲心跳PING消息接收处理
			case PING:
				PingMsg ping = (PingMsg)msg;
				if(String.valueOf(IdleState.READER_IDLE).equals(ping.getType())) {
					String remote = ctx.channel().remoteAddress().toString();
					String remoteIP = remote.substring(1, remote.indexOf(Constant.STR_COLON));
					String address = remoteIP + Constant.STR_COLON + ping.getCport();
					
					RegisterResMsg regResMsg = new RegisterResMsg();
					regResMsg.setStatus(Constant.STATUS_SUCCESS);
					regResMsg.setServiceMap(RegisterServerInfoMap.getServerInfoMap());
					CenterServerClientMap.send(address, regResMsg);
					logger.info("接收到" + address + "的[" + ping.getType() + "]PING消息!");
				}
				break;
			
			//客户端向中心服务进行注册消息接收处理
			case REG:
				RegisterMsg regMsg = (RegisterMsg)msg;
				RegProcess(ctx, regMsg);
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
		CenterServerClientMap.remove((SocketChannel)ctx.channel());
		logger.info("remote address: " + ctx.channel().remoteAddress() + ", " + cause.getMessage()); 
	}
	
	//注册过程处理
	protected void RegProcess(ChannelHandlerContext ctx, RegisterMsg regMsg) {
		String server = regMsg.getServer();
		
		String remote = ctx.channel().remoteAddress().toString();
		String remoteIP = remote.substring(1, remote.indexOf(Constant.STR_COLON));
		String address = remoteIP + Constant.STR_COLON + regMsg.getCport();
		
		//socket信息写入CenterServerClientMap
		if(CenterServerClientMap.get(address) == null)
			CenterServerClientMap.put(address, (SocketChannel)ctx.channel());
		
		//写入服务注册类，作为信息发送给注册服务
		RegisterServerInfoMap.put(server, address);
		
		RegisterResMsg regResMsg = new RegisterResMsg();
		regResMsg.setStatus(Constant.STATUS_SUCCESS);
		regResMsg.setServiceMap(RegisterServerInfoMap.getServerInfoMap());
		CenterServerClientMap.broadcast(regResMsg);
		
		logger.info(regMsg.getServer() + "[" + remote + "]向中心服务注册成功!");
	}
}
