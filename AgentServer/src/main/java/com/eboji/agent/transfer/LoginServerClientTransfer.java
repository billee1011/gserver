package com.eboji.agent.transfer;

import io.netty.channel.socket.SocketChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginServerClientTransfer {
	private static final Logger logger = LoggerFactory.getLogger(LoginServerClientTransfer.class);
	
	private static Map<String, SocketChannel> socketChannelMap = new ConcurrentHashMap<String, SocketChannel>();
	public static Map<String, SocketChannel> getSocketChannelMap() {
		return socketChannelMap;
	}

	public static void setSocketChannelMap(
			Map<String, SocketChannel> socketChannelMap) {
		LoginServerClientTransfer.socketChannelMap = socketChannelMap;
	}

	public static List<String> getLoginList() {
		return loginList;
	}

	public static void setLoginList(List<String> loginList) {
		LoginServerClientTransfer.loginList = loginList;
	}

	private static List<String> loginList = new ArrayList<String>();
	
	public static void write(Object obj) {
		Random rd = new Random(System.currentTimeMillis());
		int random = rd.nextInt(loginList.size());
		
		String key = loginList.get(random);
		logger.info("send request to [" + key +  "]");
		
		socketChannelMap.get(key).writeAndFlush(obj);
	}
}
