package com.eboji.agent.transfer.facade;

import com.eboji.agent.transfer.tcp.ServerClientTransfer;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.mj.MjCreateMsg;
import com.eboji.model.message.mj.MjStartMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//登录转发处理
		if(obj instanceof LoginMsg) {
			ServerClientTransfer.login(obj);
		} else if(obj instanceof MjStartMsg) {
			ServerClientTransfer.processMj(obj);
		} else if(obj instanceof MjCreateMsg) {
			ServerClientTransfer.processMj(obj);
		}
	}
}
