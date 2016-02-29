package com.eboji.agent.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eboji.agent.transfer.facade.TransferFacade;
import com.eboji.agent.util.JSONUtil;
import com.eboji.agent.util.RandomUtil;
import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.LoginMsg;

public class AgentServerHandler extends SimpleChannelInboundHandler<String> {
	private static final Logger logger = LoggerFactory.getLogger(AgentServerHandler.class);
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		AgentServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("channel active.");
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		//读取请求的类型直接转发至各特定的服务进行处理
		//1. msg解析为JSON对象
		try {
			JSONObject obj = JSON.parseObject(msg);
			String type = obj.getString(Constant.KEY_TYPE);
			String uID = obj.getString(Constant.KEY_UID);
			
			if(MsgType.LOGIN.equals(MsgType.valueOf(type))) {
				//生成一个唯一标识符
				String uuid = RandomUtil.getRandomGUID();
				
				//将接收信息转化为LoginMsg对象，设置唯一cid值
				LoginMsg loginMsg = JSONObject.toJavaObject(obj, LoginMsg.class);
				loginMsg.setCid(uuid);
				
				//将SocketChannle放入map
				AgentServerClientMap.put(uuid, (SocketChannel)ctx.channel());
				
				//将登陆请求转发至登陆服务进行业务处理
				TransferFacade.facade(loginMsg);
			} else {
				//1、进行用户验证(通过LoginServer服务进行验证)
				if(uID != null) {
					//游戏逻辑请求，转换成相应的消息类实例，转发至游戏服务进行业务处理
					Object o = JSONUtil.JSONObject2Object(obj, type);
					TransferFacade.facade(o);
				} else {
					//用户重新登录消息
					ctx.writeAndFlush(new Object());
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
