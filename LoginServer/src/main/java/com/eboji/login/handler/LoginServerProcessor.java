package com.eboji.login.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.login.server.transfer.facade.TransferFacade;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.LoginMsg;

public class LoginServerProcessor {
	private static final Logger logger = LoggerFactory.getLogger(LoginServerProcessor.class);
	
	//登录逻辑处理入口分发类
	public void process(BaseMsg obj, String remoteAddress) {
		logger.debug("登录处理开始");
		
		if(obj instanceof LoginMsg) {
			//登录校验
			LoginMsg loginMsg = (LoginMsg)obj;
			loginMsg.setRas(remoteAddress);
			TransferFacade.facade(loginMsg);
		}
	}
}
