package com.eboji.login.server.transfer.facade;

import com.eboji.login.server.transfer.tcp.ServerClientTransfer;
import com.eboji.model.message.LoginMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//游戏消息持久化处理
		if(obj instanceof LoginMsg) {
			ServerClientTransfer.persist(obj);
		}
	}
}
