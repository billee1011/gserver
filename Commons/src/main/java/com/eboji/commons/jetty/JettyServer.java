package com.eboji.commons.jetty;

import org.eclipse.jetty.server.Server;

public class JettyServer {
	public static void main(String[] args) throws Exception {
		Server server = JettyServerFactory.getInstance()
			.port(19091)
			.addServlet(new ServiceServlet())
			.build();
		server.start();
		
        System.out.println("System started!" );
		
	}
}
