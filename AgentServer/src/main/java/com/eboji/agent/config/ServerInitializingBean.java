package com.eboji.agent.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.eboji.agent.transfer.LoginServerClientTransfer;
import com.eboji.agent.transfer.connection.LoginServerClientConnection;
import com.eboji.agent.util.ConfigUtil;
import com.eboji.model.constant.Constant;

@Component("serverInitializingBean")
public class ServerInitializingBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		createLoginConnection();
	}
	
	/**
	 * 初始化登录服务器的连接
	 */
	protected void createLoginConnection() {
		String loginservers = ConfigUtil.getProps("loginservers");
		String[] loginserversArr = loginservers.split("\\|");
		for(String loginserver : loginserversArr) {
			String[] hostports = loginserver.split(Constant.STR_COLON);
			String host = hostports[0];
			int port = Integer.parseInt(hostports[1]);
			
			LoginServerClientConnection client = new LoginServerClientConnection(port, host);
			LoginServerClientTransfer.getLoginList().add(loginserver);
			LoginServerClientTransfer.getSocketChannelMap().put(loginserver, client.getSocketChannel());
		}
	}
}
