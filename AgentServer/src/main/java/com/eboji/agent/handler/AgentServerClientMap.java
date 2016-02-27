package com.eboji.agent.handler;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.eboji.model.message.BaseMsg;

public class AgentServerClientMap {
	private static final Logger logger = LoggerFactory.getLogger(AgentServerClientMap.class);
	
	private static Map<String, SocketChannel> userMap = new ConcurrentHashMap<String, SocketChannel>();
	
	protected static void println() {
		for(Map.Entry<String, SocketChannel> entry : userMap.entrySet()) {
			logger.warn("userID = " + entry.getKey());
		}
	}
	
	public static void printCount() {
		logger.info("=============CURRENT USER TOTOL: " + userMap.size());
	}
	
	public static Channel get(String userId) {
		return userMap.get(userId);
	}
	
	public static void put(String userId, SocketChannel socketChannel) {
		userMap.put(userId, socketChannel);
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
	
	public static void sendData(Object obj) {
		BaseMsg msg = (BaseMsg)obj;
		String data = JSONObject.toJSON(obj).toString();
		if(userMap.get(msg.getUid()) != null) {
			userMap.get(msg.getUid()).writeAndFlush(data);
		} else {
			logger.error("send data to " + msg.getUid() + " failed");
		}
	}
}
