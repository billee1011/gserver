package com.eboji.center.handler;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端注册信息存储类
 * @author zhoucl 2016-02-29
 *
 */
public class RegisterServerInfoMap {
	private static final Logger logger = LoggerFactory.getLogger(RegisterServerInfoMap.class);
	
	private static Map<Integer, Set<String>> serverInfoMap = 
			new ConcurrentHashMap<Integer, Set<String>>();
	
	public static Map<Integer, Set<String>> getServerInfoMap() {
		return serverInfoMap;
	}
	
	public static void put(Integer serviceId, String address) {
		if(serverInfoMap.get(serviceId) == null) {
			Set<String> addressSet = new HashSet<String>();
			addressSet.add(address);
			serverInfoMap.put(serviceId, addressSet);
		} else {
			serverInfoMap.get(serviceId).add(address);
		}
		
		logger.info("====================" + serverInfoMap.toString());
	}
	
	public static void remove(String address) {
		Integer serviceId = null;
		boolean find = false;
		for(Map.Entry<Integer, Set<String>> entry : 
			serverInfoMap.entrySet()) {
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
			serverInfoMap.get(serviceId).remove(address);
		}
	}
}
