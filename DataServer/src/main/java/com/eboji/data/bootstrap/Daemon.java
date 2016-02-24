package com.eboji.data.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eboji.data.bootstrap.config.SpringConfiguration;
import com.eboji.data.server.DataServerListener;
import com.eboji.data.util.ConfigUtil;

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
		
		logger.info("DataServer initialize context finished.");
	}
	
	public void init() {
		logger.info("DataServer initialize context is starting.");
		initContext();
	}
	
	public static Daemon getInstance() {
		return daemon;
	}

	/**
	 * AgentServer启动
	 */
	public void start() throws Exception {
		logger.info("DataServer is starting.");
		
		new DataServerListener(getPort(), ConfigUtil.getClient());
	}

	/**
	 * AgentServer重新启动
	 */
	public void restart() {

	}

	/**
	 * AgentServer停止
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
