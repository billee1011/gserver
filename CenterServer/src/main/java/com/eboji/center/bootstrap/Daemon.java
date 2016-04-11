package com.eboji.center.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eboji.center.bootstrap.config.SpringConfiguration;
import com.eboji.center.server.CenterServerListener;

public class Daemon {
	private static final Logger logger = LoggerFactory.getLogger(Daemon.class);
	
	private static final Daemon daemon = new Daemon();
	
	private int port = 9999;
	
	private ApplicationContext context = null;

	private Daemon() {
	}
	
	public void init() {
		logger.info("CenterServer initialize context is starting...");
		initContext();
	}
	
	protected void initContext() {
		setContext(null);
		setContext(new AnnotationConfigApplicationContext(SpringConfiguration.class));
		
		logger.info("CenterServer initialize context finished.");
	}
	
	public static Daemon getInstance() {
		return daemon;
	}

	/**
	 * CenterServer启动
	 */
	public void start() throws Exception {
		logger.info("CenterServer will be started...");
		
		new CenterServerListener(getPort());
	}

	/**
	 * CenterServer重新启动
	 */
	public void restart() {

	}

	/**
	 * CenterServer停止
	 */
	public void stop() {
		
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}
