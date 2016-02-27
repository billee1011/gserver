package com.eboji.agent.transfer.tcp.handler;

import java.util.Map;
import java.util.Set;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.agent.handler.AgentServerClientMap;
import com.eboji.agent.transfer.tcp.ServerClientTransfer;
import com.eboji.agent.util.ConfigUtil;
import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.ConnMsg;
import com.eboji.model.message.ConnResMsg;
import com.eboji.model.message.LoginResMsg;
import com.eboji.model.message.PingMsg;
import com.eboji.model.message.RegisterResMsg;

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
				logger.debug("send ping to server[" + ctx.channel().remoteAddress() + "]");
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
		
		//ctx.writeAndFlush(conn);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		MsgType msgType = msg.getT();
		switch (msgType) {
		case PING:
			logger.debug("receive ping from server[" + ctx.channel().remoteAddress() + "]");
			break;
			
		case CONNRES:
			ConnResMsg connResMsg = (ConnResMsg)msg;
			logger.info("receive server msg: " + connResMsg.getStatus());
			break;
			
		case LOGINRES:
			LoginResMsg loginRes = (LoginResMsg)msg;
			Channel channel = AgentServerClientMap.get(loginRes.getCid());
			if(loginRes.getStatus().equals("OK")) {
				AgentServerClientMap.put(loginRes.getUid(), (SocketChannel)channel);
				AgentServerClientMap.remove(loginRes.getCid());
				AgentServerClientMap.printCount();
				
				logger.info("用户[" + loginRes.getUid() +"]登陆成功!"); 
				channel.writeAndFlush("{\"status\": \"1\", \"message\": \"Login Success\", \"uid\": \"UID\"}");
			} else {
				channel.writeAndFlush("{\"status\": \"-1\", \"message\": \"Login Failed\", \"uid\": \"FAILE UID\"}");
			}
			break;
			
		case REGRES:		//中心注册响应
			RegisterResMsg regResMsg = (RegisterResMsg)msg;
			Map<Integer, Set<String>> sets = regResMsg.getServiceMap();
			ServerClientTransfer.parse(sets);
			
			logger.info("接收中心注册信息成功!");
			break;
		default:
			//进行游戏服务信息的解析，获取需要转发的数据
			String uId = msg.getUid();
			AgentServerClientMap.get(uId).writeAndFlush(msg);
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
