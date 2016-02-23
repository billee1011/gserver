package com.eboji.agent.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("serverInitializingBean")
public class ServerInitializingBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		//TODO
	}
}
