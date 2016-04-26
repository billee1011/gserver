package com.eboji.game.server.transfer;

import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.commons.msg.JoinRoomNoMemMsg;

public class TransferFacade {
	public static void facade(Object obj) {
		//游戏消息持久化处理
		if(obj instanceof CreateRoomMsg) {
			TransferProcessor.persist(obj);
		} else if(obj instanceof JoinRoomMsg) {
			TransferProcessor.persist(obj);
		} else if(obj instanceof JoinRoomNoMemMsg) {
			TransferProcessor.persist(obj);
		}
	}
}
