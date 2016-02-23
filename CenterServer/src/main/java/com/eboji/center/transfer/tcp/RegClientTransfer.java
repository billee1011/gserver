package com.eboji.center.transfer.tcp;

import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.RegisterMsg;

public class RegClientTransfer {
	private static final Logger logger = LoggerFactory.getLogger(RegClientTransfer.class);
	
	private static Map<String, SocketChannel> socketChannelMap = new ConcurrentHashMap<String, SocketChannel>();
	private static Map<String, Integer> serviceMap = new ConcurrentHashMap<String, Integer>();
	
	public static Map<String, SocketChannel> getSocketChannelMap() {
		return socketChannelMap;
	}

	public static void setSocketChannelMap(
			Map<String, SocketChannel> socketChannelMap) {
		RegClientTransfer.socketChannelMap = socketChannelMap;
	}

	public static Map<String, Integer> getServiceMap() {
		return serviceMap;
	}

	public static void setServiceMap(Map<String, Integer> serviceMap) {
		RegClientTransfer.serviceMap = serviceMap;
	}

	public static void write(RegisterMsg obj) {
		for(Map.Entry<String, SocketChannel> entry : socketChannelMap.entrySet()) {
			logger.info("中心服务向[" + entry.getKey() + "]发起申请,要求其向自己注册服务!");
			
			obj.setServerId(serviceMap.get(entry.getKey()));
			if(Constant.SRV_AGENT == obj.getServerId()) {
				String str = JSONObject.toJSONString(obj);
				entry.getValue().writeAndFlush(str);
			} else {
				entry.getValue().writeAndFlush(obj);
			}
		}
	}
}
