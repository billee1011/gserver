package com.eboji.game.server.transfer.facade;

import com.eboji.game.server.transfer.tcp.ServerClientTransfer;
import com.eboji.model.message.CreateRoomMsg;
import com.eboji.model.message.JoinRoomMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//游戏消息持久化处理
		if(obj instanceof CreateRoomMsg) {
			ServerClientTransfer.persist(obj);
		} else if(obj instanceof JoinRoomMsg) {
			ServerClientTransfer.persist(obj);
		}
	}
}
