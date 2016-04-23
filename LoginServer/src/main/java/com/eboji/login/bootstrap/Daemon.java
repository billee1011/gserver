package com.eboji.login.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eboji.login.bootstrap.config.SpringConfiguration;
import com.eboji.login.server.LoginServerListener;

public class Daemon {
	private static final Logger logger = LoggerFactory.getLogger(Daemon.class);
	
	private static final Daemon daemon = new Daemon();
	
	private int port = 9091;
	
	private ApplicationContext context = null;

	private Daemon() {
	}
	
	protected void initContext() {
		setContext(null);
		setContext(new AnnotationConfigApplicationContext(SpringConfiguration.class));
		logger.info("LoginServer initialize context finished.");
	}
	
	public void init() {
		logger.info("LoginServer initialize context is starting.");
		initContext();
	}
	
	public synchronized static Daemon getInstance() {
		return daemon;
	}

	/**
	 * LoginServer启动
	 */
	public void start() throws Exception {
		new LoginServerListener(getPort());
	}

	/**
	 * LoginServer重新启动
	 */
	public void restart() {

	}

	/**
	 * LoginServer停止
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
