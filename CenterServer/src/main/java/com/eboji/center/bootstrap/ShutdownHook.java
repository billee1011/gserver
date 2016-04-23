package com.eboji.center.bootstrap;

import io.netty.channel.socket.SocketChannel;

import java.util.Iterator;
import java.util.Map.Entry;

import org.slf4j.LoggerFactory;

import com.eboji.center.server.CenterServerClientMap;

import org.slf4j.Logger;

public class ShutdownHook {
	private static final Logger logger = LoggerFactory.getLogger(ShutdownHook.class);
	
	public static void doShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				logger.info("CenterServer is stopping.");
				
				dofinish();
				
				logger.info("CenterServer has been stopped.");
			}
		});
	}
	
	private static void dofinish() {
		Iterator<Entry<String, SocketChannel>> iter = 
				CenterServerClientMap.getClientMap().entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, SocketChannel> entry = iter.next();
			entry.getValue().close();
		}
		
		logger.info("CenterServer is trying to finish all works!");
	}
}
