package com.eboji.agent.handler;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgentServerClientMap {
	private static final Logger logger = LoggerFactory.getLogger(AgentServerClientMap.class);
	
	private static Map<String, SocketChannel> userMap = new ConcurrentHashMap<String, SocketChannel>();
	
	protected static void println() {
		for(Map.Entry<String, SocketChannel> entry : userMap.entrySet()) {
			logger.warn("userID = " + entry.getKey());
		}
	}
	
	public static Channel get(String userId) {
		return userMap.get(userId);
	}
	
	public static void put(String userId, SocketChannel socketChannel) {
		userMap.put(userId, socketChannel);
		
		println();
	}
	
	public static void remove(String userId) {
		userMap.remove(userId);
	}
	
	public static void remove(SocketChannel socketChannel) {
		for(Map.Entry<String, SocketChannel> entry : userMap.entrySet()) {
			if(entry.getValue() == socketChannel) {
				userMap.remove(entry.getKey());
			}
		}
	}
	
	public static int getUserCount() {
		return userMap.size();
	}
}
