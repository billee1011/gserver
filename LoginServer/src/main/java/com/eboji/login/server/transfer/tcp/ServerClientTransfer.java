package com.eboji.login.server.transfer.tcp;

import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerClientTransfer {
	private static final Logger logger = LoggerFactory.getLogger(ServerClientTransfer.class);
	
	private static Map<String, SocketChannel> socketChannelMap = new ConcurrentHashMap<String, SocketChannel>();
	private static Map<Integer, Set<String>> serviceMap = new ConcurrentHashMap<Integer, Set<String>>();
	
	public static Map<String, SocketChannel> getSocketChannelMap() {
		return socketChannelMap;
	}

	public static void setSocketChannelMap(
			Map<String, SocketChannel> socketChannelMap) {
		ServerClientTransfer.socketChannelMap = socketChannelMap;
	}
	
	public static Map<Integer, Set<String>> getServiceMap() {
		return serviceMap;
	}

	public static void setServiceMap(Map<Integer, Set<String>> serviceMap) {
		ServerClientTransfer.serviceMap = serviceMap;
	}

	public static void write(Integer serviceId, Object obj) {
		Set<String> serviceSets = serviceMap.get(serviceId);
		if(serviceSets != null && serviceSets.size() > 0) {
			String key = null;
			if(serviceSets.size() > 1) {
				Random rd = new Random(System.currentTimeMillis());
				int random = rd.nextInt(serviceSets.size());
				
				key = (String)serviceSets.toArray()[random];
			} else {
				key = (String)serviceSets.toArray()[0];
			}
			logger.info("send request to [" + key +  "]");
			
			socketChannelMap.get(key).writeAndFlush(obj);
		}
	}
}
