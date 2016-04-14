package com.eboji.model.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.model.common.GameType;
import com.eboji.model.constant.Constant;

public class CommonUtil {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	
	public static void printRegisters(Map<String, Set<String>> serverInfoMap) {
		if(serverInfoMap != null && serverInfoMap.size() > 0) {
			logger.info("注册服务信息:");
			Iterator<Entry<String, Set<String>>> iter = serverInfoMap.entrySet().iterator();
			while(iter.hasNext()) {
				Entry<String, Set<String>> entry = iter.next();
				String key = entry.getKey();
				if(key.contains(Constant.SRV_AGENT)) {
					logger.info("--->代理服务(" + Constant.SRV_AGENT + "):" + entry.getValue());
				} else if(key.contains(Constant.SRV_LOGIN)) {
					logger.info("--->登录服务(" + Constant.SRV_LOGIN + "):" + entry.getValue());
				} else if(key.contains(Constant.SRV_GAME)) {
					Set<String> sets = entry.getValue();
					Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
					for(String s : sets) {
						String[] sp = s.split(Constant.STR_UNDERLINE);
						int gameId = Integer.parseInt(sp[0]);
						String address = sp[1];
						if(map.get(gameId) == null || map.get(gameId).size() <= 0) {
							Set<String> addresses = new HashSet<String>();
							addresses.add(address);
							map.put(gameId, addresses);
						} else {
							map.get(gameId).add(address);
						}
					}
					
					GameType[] types = GameType.values();
					for(GameType type : types) {
						if(map.get(type.getID()) != null) {
							logger.info("--->游戏服务(" + type.getName() + "[" + type.getID() + "]):" 
									+ map.get(type.getID()));
						}
					}
				} else if(key.contains(Constant.SRV_DATA)) {
					logger.info("--->数据服务(" + Constant.SRV_DATA + "):" + entry.getValue());
				} else if(key.contains(Constant.SRV_IM)) {
					logger.info("--->消息服务(" + Constant.SRV_IM + "):" + entry.getValue());
				}
			}
		}
	}
	
	public static void printConnections(Map<String, Set<String>> serviceMap) {
		if(serviceMap != null && serviceMap.size() > 0) {
			logger.info("建立的TCP连接:");
			Iterator<String> iter = serviceMap.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				if(key.contains(Constant.SRV_AGENT)) {
					logger.info("--->代理服务:" + serviceMap.get(key).toString());
				} else if(key.contains(Constant.SRV_LOGIN)) {
					logger.info("--->登录服务:" + serviceMap.get(key).toString());
				} else if(key.contains(Constant.SRV_GAME)) {
					logger.info("--->游戏服务:" + serviceMap.get(key).toString());
				} else if(key.contains(Constant.SRV_DATA)) {
					logger.info("--->数据服务:" + serviceMap.get(key).toString());
				} else if(key.contains(Constant.SRV_IM)) {
					logger.info("--->消息服务:" + serviceMap.get(key).toString());
				} else if(key.contains(Constant.SRV_CENTER)) {
					logger.info("--->中心服务:" + serviceMap.get(key).toString());
				}
			}
		}
	}
}
