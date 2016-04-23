package com.eboji.login.server.transfer;

import com.eboji.commons.msg.LoginMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//游戏消息持久化处理
		if(obj instanceof LoginMsg) {
			TransferProcessor.persist(obj);
		}
	}
}
