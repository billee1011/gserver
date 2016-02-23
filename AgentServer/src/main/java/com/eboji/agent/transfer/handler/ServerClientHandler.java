package com.eboji.agent.transfer.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.agent.handler.AgentServerClientMap;
import com.eboji.agent.util.ConfigUtil;
import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.ConnMsg;
import com.eboji.model.message.ConnResMsg;
import com.eboji.model.message.LoginResMsg;
import com.eboji.model.message.PingMsg;

public class ServerClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(ServerClientHandler.class);
	
	//利用写空闲发送心跳检测消息
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if(evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent)evt;
			switch (e.state()) {
			case WRITER_IDLE:
				PingMsg pingMsg = new PingMsg();
				ctx.writeAndFlush(pingMsg);
				logger.info("send ping to server[" + ctx.channel().remoteAddress() + "]");
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ConnMsg conn = new ConnMsg();
		conn.setCid(ConfigUtil.getProps("serverid"));
		
		ctx.writeAndFlush(conn);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		MsgType msgType = msg.getT();
		switch (msgType) {
		case PING:
			logger.info("receive ping from server[" + ctx.channel().remoteAddress() + "]");
			break;
			
		case CONNRES:
			ConnResMsg connResMsg = (ConnResMsg)msg;
			logger.info("receive server msg: " + connResMsg.getStatus());
			break;
			
		case LOGINRES:
			LoginResMsg loginRes = (LoginResMsg)msg;
			Channel channel = AgentServerClientMap.get(loginRes.getCid());
			if(loginRes.getStatus().equals("OK")) {
				AgentServerClientMap.remove(loginRes.getCid());
				AgentServerClientMap.put(loginRes.getUserId(), (SocketChannel)channel);
				
				logger.info("用户[" + loginRes.getUserId() +"]登陆成功!"); 
				channel.writeAndFlush("{\"status\": \"Login SUCCESS\"}");
			} else {
				channel.writeAndFlush("{\"status\": \"Login FAILED\"}");
			}
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
