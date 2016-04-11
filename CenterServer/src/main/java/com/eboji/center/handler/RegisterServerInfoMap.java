package com.eboji.center.handler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.model.constant.Constant;

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
		
		printRegisters();
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
			printRegisters();
		}
	}
	
	private static void printRegisters() {
		Iterator<Entry<Integer, Set<String>>> iter = serverInfoMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, Set<String>> entry = iter.next();
			if(entry.getKey().intValue() == Constant.SRV_AGENT) {
				logger.info("代理服务(" + Constant.SRV_AGENT + "):" + entry.getValue());
			} else if(entry.getKey().intValue() == Constant.SRV_LOGIN) {
				logger.info("登录服务(" + Constant.SRV_LOGIN + "):" + entry.getValue());
			} else if(entry.getKey().intValue() == Constant.SRV_GAME) {
				logger.info("游戏服务(" + Constant.SRV_GAME + "):" + entry.getValue());
			} else if(entry.getKey().intValue() == Constant.SRV_DATA) {
				logger.info("数据服务(" + Constant.SRV_DATA + "):" + entry.getValue());
			} else if(entry.getKey().intValue() == Constant.SRV_IM) {
				logger.info("消息服务(" + Constant.SRV_IM + "):" + entry.getValue());
			}
		}
	}
}
