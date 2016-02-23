package com.eboji.agent.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eboji.agent.bootstrap.Daemon;
import com.eboji.agent.transfer.ServerClientFactory;
import com.eboji.agent.transfer.ServerClientTransfer;
import com.eboji.agent.util.RandomUtil;
import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.RegisterMsg;

public class AgentServerHandler extends SimpleChannelInboundHandler<String> {
	private static final Logger logger = LoggerFactory.getLogger(AgentServerHandler.class);
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		AgentServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("--------------------");
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
			
			//根据type,gid进行转发
			logger.info("type = " + type);
			logger.info("gid = " + gid);
			
			if(MsgType.LOGIN.equals(MsgType.valueOf(type))) {
				//生成一个唯一标识符
				String uuid = RandomUtil.getRandomGUID();
				
				//将接收信息转化为LoginMsg对象，设置唯一cid值
				LoginMsg loginMsg = JSONObject.toJavaObject(obj, LoginMsg.class);
				loginMsg.setCid(uuid);
				
				//将SocketChannle放入map
				AgentServerClientMap.put(uuid, (SocketChannel)ctx.channel());
				
				//将登陆信息转入登陆服务进行业务处理
				ServerClientTransfer.write(Constant.SRV_LOGIN, loginMsg);
			} else if(MsgType.REG.equals(MsgType.valueOf(type))) {
				RegisterMsg regMsg = JSONObject.toJavaObject(obj, RegisterMsg.class);
				
				String remote = ctx.channel().remoteAddress().toString();
				ServerClientFactory.initConnection(remote.substring(1, remote.indexOf(Constant.STR_COLON)), 
						regMsg.getPort(), Constant.SRV_CENTER);
				
				regMsg.setCport(Daemon.getInstance().getPort());
				regMsg.setServerId(Constant.SRV_AGENT);
				ServerClientTransfer.write(Constant.SRV_CENTER, regMsg);
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
