package com.eboji.data.bootstrap;

import org.slf4j.LoggerFactory;

import com.eboji.data.server.DataServerExecutors;

import org.slf4j.Logger;

public class ShutdownHook {
	private static final Logger logger = LoggerFactory.getLogger(ShutdownHook.class);
	
	public static void doShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				logger.info("DataServer is stopping...");
				
				dofinish();
				
				logger.info("DataServer has been stopped.");
			}
		});
	}
	
	private static void dofinish() {
		logger.info("DataServer is trying to finish all works!");
		if(DataServerExecutors.getService() != null) {
			DataServerExecutors.getService().shutdownNow();
		}
	}
}
