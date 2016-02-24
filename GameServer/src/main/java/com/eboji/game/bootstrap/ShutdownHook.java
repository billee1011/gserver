package com.eboji.game.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutdownHook {
	private static final Logger logger = LoggerFactory.getLogger(ShutdownHook.class);
	
	public static void doShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				logger.info("GameServer is stopping...");
				
				dofinish();
				
				logger.info("GameServer has been stopped.");
			}
		});
	}
	
	private static void dofinish() {
		logger.info("finish closing all work!");
	}
}
