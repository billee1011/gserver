package com.eboji.center.handler;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterServerInfoMap {
	private static Map<Integer, Set<String>> serverInfoMap = 
			new ConcurrentHashMap<Integer, Set<String>>();
	
	public static Map<Integer, Set<String>> getServerInfoMap() {
		return serverInfoMap;
	}
	
	public static Map<Integer, Set<String>> getTransferServerInfoMap(String address) {
		Map<Integer, Set<String>> retMap = new ConcurrentHashMap<Integer, Set<String>>();
		Set<Integer> keys = serverInfoMap.keySet();
		for(Integer key : keys) {
			Set<String> value = serverInfoMap.get(key);
			Set<String> reVal = new HashSet<String>();
			
			for(String v : value) {
				reVal.add(v);
			}
			
			retMap.put(key, reVal);
		}
		
		Integer serviceId = null;
		boolean find = false;
		for(Map.Entry<Integer, Set<String>> entry : 
			retMap.entrySet()) {
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
			retMap.get(serviceId).remove(address);
		}
		
		return retMap;
	}

	public static void put(Integer serviceId, String address) {
		if(serverInfoMap.get(serviceId) == null) {
			Set<String> addressSet = new HashSet<String>();
			addressSet.add(address);
			serverInfoMap.put(serviceId, addressSet);
		} else {
			serverInfoMap.get(serviceId).add(address);
		}
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
