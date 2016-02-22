package com.eboji.center.bootstrap.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("serverInitializingBean")
public class ServerInitializingBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		//TODO
	}
	
}
