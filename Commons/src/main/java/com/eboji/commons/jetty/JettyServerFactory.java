package com.eboji.commons.jetty;

import java.util.concurrent.Executors;

import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;

public class JettyServerFactory {
	private int port = 8080;
	private HttpServlet servlet = null;
	
	private static JettyServerFactory factory = null;
	private JettyServerFactory() {}
	
	public synchronized static JettyServerFactory  getInstance() {
		if(factory == null) {
			factory = new JettyServerFactory();
		}
		
		return factory;
	}
	
	public JettyServerFactory port(int port) {
		this.port = port;
		return this;
	}
	
	public JettyServerFactory addServlet(HttpServlet servlet) {
		this.servlet = servlet;
		return this;
	}
	
	public Server build() {
		if(this.servlet == null) {
			return null;
		}
		ServletContextHandler servletContextHandler = 
				new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		servletContextHandler.setContextPath("/");
		servletContextHandler.addServlet(new ServletHolder(this.servlet), "/service");
		
		ThreadPool threadPool = new ExecutorThreadPool(Executors.newFixedThreadPool(4));
		
		Server server = new Server(threadPool);
		ServerConnector connector = new ServerConnector(server);
        connector.setPort(this.port);
        
        server.setHandler(servletContextHandler);
		server.addConnector(connector);
		server.setStopAtShutdown(true);
		
		return server;
	}
}
