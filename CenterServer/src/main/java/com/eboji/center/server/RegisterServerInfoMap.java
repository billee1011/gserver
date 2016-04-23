package com.eboji.center.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.eboji.commons.Constant;
import com.eboji.commons.util.CommonUtil;

/**
 * 客户端注册信息存储类
 * @author zhoucl 2016-02-29
 *
 */
public class RegisterServerInfoMap {
	private static Map<String, Set<String>> serverInfoMap = 
			new ConcurrentHashMap<String, Set<String>>();
	
	public static Map<String, Set<String>> getServerInfoMap() {
		return serverInfoMap;
	}
	
	public static void put(String server, String address) {
		String[] servers = server.split(Constant.STR_UNDERLINE);
		String realServer = server;
		String gameIds = "";
		if(servers.length > 1) {
			realServer = servers[0];
			gameIds = servers[1];
		}
		
		if(serverInfoMap.get(realServer) == null) {
			Set<String> addressSet = new HashSet<String>();
			if(gameIds.equals("")) {
				addressSet.add(address);
				serverInfoMap.put(realServer, addressSet);
			} else {
				String[] gameIdArr = gameIds.split("\\|");
				for(String gameId : gameIdArr) {
					addressSet.add(gameId + Constant.STR_UNDERLINE + address);
				}
				serverInfoMap.put(realServer, addressSet);
			}
		} else {
			if(gameIds.equals("")) {
				serverInfoMap.get(realServer).add(address);
			} else {
				String[] gameIdArr = gameIds.split("\\|");
				for(String gameId : gameIdArr) {
					serverInfoMap.get(realServer).add(gameId + Constant.STR_UNDERLINE + address);
				}
			}
		}
		
		CommonUtil.printRegisters(serverInfoMap);
	}
	
	public static void remove(String address) {
		String server = null;
		List<String> addressList = new ArrayList<String>();
		boolean find = false;
		for(Map.Entry<String, Set<String>> entry : 
			serverInfoMap.entrySet()) {
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
				serverInfoMap.get(server).remove(addr);
			}
			CommonUtil.printRegisters(serverInfoMap);
		}
	}
}
