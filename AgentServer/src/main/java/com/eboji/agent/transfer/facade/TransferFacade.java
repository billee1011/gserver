package com.eboji.agent.transfer.facade;

import com.eboji.agent.transfer.tcp.ServerClientTransfer;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.CreateRoomMsg;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.JoinRoomMsg;
import com.eboji.model.message.mj.MjStartMsg;

public class TransferFacade {
	public static void facade(BaseMsg obj) {
		//登录转发处理
		if(obj instanceof LoginMsg) {
			ServerClientTransfer.login(obj);
		} else if(obj instanceof MjStartMsg) {
			ServerClientTransfer.processMj(obj);
		} else if(obj instanceof CreateRoomMsg) {
			ServerClientTransfer.processMj(obj);
		} else if(obj instanceof JoinRoomMsg) {
			ServerClientTransfer.processMj(obj);
		}
	}
}
