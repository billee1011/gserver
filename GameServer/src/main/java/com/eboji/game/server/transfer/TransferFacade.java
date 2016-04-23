package com.eboji.game.server.transfer;

import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//游戏消息持久化处理
		if(obj instanceof CreateRoomMsg) {
			TransferProcessor.persist(obj);
		} else if(obj instanceof JoinRoomMsg) {
			TransferProcessor.persist(obj);
		}
	}
}
