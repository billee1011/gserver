package com.eboji.center.handler;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.eboji.model.constant.Constant;
import com.eboji.model.message.RegisterResMsg;

/**
 * 存储TCP连接至中心服务的客户端信息类
 * @author zhoucl 2016-02-29
 *
 */
public class CenterServerClientMap {
	/**
	 * 存储client的map变量
	 */
	private static Map<String, SocketChannel> clientMap = new ConcurrentHashMap<String, SocketChannel>();
	
	public static Map<String, SocketChannel> getClientMap() {
		return clientMap;
	}

	/**
	 * 将socket客户端信息添加进map
	 * @param clientId		使用客户端连接的ip和port(客户端作为服务指定的监听端口)
	 * @param socketChannel	{@link SocketChannel}
	 */
	public static void put(String clientId, SocketChannel socketChannel) {
		clientMap.put(clientId, socketChannel);
	}
	
	/**
	 * 通过clientId获取socketChannel
	 * @param clientId 使用客户端连接的ip和port(客户端作为服务指定的监听端口)
	 * @return {@link SocketChannel}
	 */
	public static Channel get(String clientId) {
		return clientMap.get(clientId);
	}
	
	/**
	 * 移除Map中的SocketChannel信息
	 * @param socketChannel
	 */
	public static void remove(SocketChannel socketChannel) {
		for(Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
			if(entry.getValue() == socketChannel) {
				clientMap.remove(entry.getKey());
				//同时删除注册服务Map中的信息
				RegisterServerInfoMap.remove(entry.getKey());
			}
		}
	}
	
	/**
	 * 将obj信息广播至连接至中心服务的客户端信息
	 * @param obj
	 */
	public static void broadcast(Object obj) {
		Map<String, Set<String>> serverInfoMap = RegisterServerInfoMap
				.getServerInfoMap();
		Set<String> broadcastSET = new HashSet<String>();
		for(Map.Entry<String, Set<String>> entry : serverInfoMap.entrySet()) {
			Set<String> addressSet = entry.getValue();
			for(String address : addressSet) {
				String realAddress = address.split(Constant.STR_UNDERLINE).length > 1 ?
						address.split(Constant.STR_UNDERLINE)[1]: address;
				if(!broadcastSET.contains(realAddress)) {
					broadcastSET.add(realAddress);
					Object sendObj = filter(realAddress, obj);
					clientMap.get(realAddress).writeAndFlush(sendObj);
				}
			}
		}
	}
	
	/**
	 * 将obj信息发送至连接至中心服务的客户端信息
	 * @param address
	 * @param obj
	 */
	public static void send(String address, Object obj) {
		Object sendObj = filter(address, obj);
		clientMap.get(address).writeAndFlush(sendObj);
	}
	
	/**
	 * 过滤不需要广播的信息，比如客户端为127.0.0.1:9090的客户端,<br />
	 * 不需要广播他自己的信息过去
	 * @param address	广播的客户端ip和端口
	 * @param obj		需要广播的注册返回信息
	 * @return	{@link RegisterResMsg}
	 */
	private static Object filter(String address, Object obj) {
		RegisterResMsg retMsg = null;
		if(obj instanceof RegisterResMsg) {
			RegisterResMsg msg = (RegisterResMsg)obj;
			
			retMsg = new RegisterResMsg();
			retMsg.setCid(msg.getCid());
			retMsg.setGid(msg.getCid());
			retMsg.setT(msg.getT());
			retMsg.setStatus(msg.getStatus());
			
			Map<String, Set<String>> serverInfoMap = msg.getServiceMap();
			Map<String, Set<String>> dynamicServerInfoMap = new 
					ConcurrentHashMap<String, Set<String>>();
			
			//serverInfoMap拷贝至dynamicServerInfoMap
			Set<String> keys = serverInfoMap.keySet();
			for(String key : keys) {
				Set<String> value = serverInfoMap.get(key);
				Set<String> reVal = new HashSet<String>();
				
				for(String v : value) {
					reVal.add(v);
				}
				
				dynamicServerInfoMap.put(key, reVal);
			}
			
			String server = null;
			boolean find = false;
			List<String> addressList = new ArrayList<String>();
			for(Map.Entry<String, Set<String>> entry : 
				dynamicServerInfoMap.entrySet()) {
				Set<String> addressSet = entry.getValue();
				for(String addr : addressSet) {
					if(addr.contains(address)) {
						find = true;
						server = entry.getKey();
						addressList.add(addr);
					}
				}
				
				if(find) {
					break;
				}
			}
			
			if(server != null) {
				for(String addr : addressList) {
					dynamicServerInfoMap.get(server).remove(addr);
				}
			}
			
			retMsg.setServiceMap(dynamicServerInfoMap);
		}
		
		return retMsg;
	}
}
