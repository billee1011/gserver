package com.eboji.center.handler;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.eboji.model.message.RegisterResMsg;

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
				//同时删除注册服务Map中的信息
				RegisterServerInfoMap.remove(entry.getKey());
			}
		}
	}
	
	public static void broadcast(Object obj) {
		Map<Integer, Set<String>> serverInfoMap = RegisterServerInfoMap.getServerInfoMap();
		for(Map.Entry<Integer, Set<String>> entry : serverInfoMap.entrySet()) {
			Set<String> addressSet = entry.getValue();
			for(String address : addressSet) {
				Object sendObj = filter(address, obj);
				clientMap.get(address).writeAndFlush(sendObj);
			}
		}
	}
	
	private static Object filter(String address, Object obj) {
		RegisterResMsg retMsg = null;
		if(obj instanceof RegisterResMsg) {
			RegisterResMsg msg = (RegisterResMsg)obj;
			
			retMsg = new RegisterResMsg();
			retMsg.setCid(msg.getCid());
			retMsg.setGid(msg.getCid());
			retMsg.setT(msg.getT());
			retMsg.setStatus(msg.getStatus());
			
			Map<Integer, Set<String>> serverInfoMap = msg.getServiceMap();
			Map<Integer, Set<String>> dynamicServerInfoMap = new ConcurrentHashMap<Integer, Set<String>>();
			Set<Integer> keys = serverInfoMap.keySet();
			for(Integer key : keys) {
				Set<String> value = serverInfoMap.get(key);
				Set<String> reVal = new HashSet<String>();
				
				for(String v : value) {
					reVal.add(v);
				}
				
				dynamicServerInfoMap.put(key, reVal);
			}
			
			Integer serviceId = null;
			boolean find = false;
			for(Map.Entry<Integer, Set<String>> entry : 
				dynamicServerInfoMap.entrySet()) {
				Set<String> addressSet = entry.getValue();
				for(String addr : addressSet) {
					if(addr.equals(address)) {
						find = true;
						serviceId = entry.getKey();
						break;
					}
				}
				
				if(find) {
					break;
				}
			}
			
			if(serviceId != null) {
				dynamicServerInfoMap.get(serviceId).remove(address);
			}
			
			retMsg.setServiceMap(dynamicServerInfoMap);
		}
		
		return retMsg;
	}
}
