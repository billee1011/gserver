package com.eboji.agent.transfer.facade;

import com.eboji.agent.transfer.tcp.ServerClientTransfer;
import com.eboji.model.message.LoginMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//登录转发处理
		if(obj instanceof LoginMsg) {
			ServerClientTransfer.login(obj);
		}
	}
}
