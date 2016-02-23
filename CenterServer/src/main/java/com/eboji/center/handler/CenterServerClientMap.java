package com.eboji.center.handler;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CenterServerClientMap {
	private static Map<String, SocketChannel> clientMap = new ConcurrentHashMap<String, SocketChannel>();
	
	public static void put(String clientId, SocketChannel socketChannel) {
		clientMap.put(clientId, socketChannel);
	}
	
	public static Channel get(String clientId) {
		return clientMap.get(clientId);
	}
	
	public static void remove(SocketChannel socketChannel) {
		for(Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
			if(entry.getValue() == socketChannel) {
				clientMap.remove(entry.getKey());
			}
		}
	}
}
