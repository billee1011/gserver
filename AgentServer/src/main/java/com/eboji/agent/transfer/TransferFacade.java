package com.eboji.agent.transfer;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.commons.msg.LoginMsg;
import com.eboji.commons.msg.ReJoinRoomMsg;

public class TransferFacade {
	public static void facade(BaseMsg obj) {
		//登录转发处理
		if(obj instanceof LoginMsg) {
			TransferProcessor.login(obj);
		} else if(obj instanceof CreateRoomMsg) {
			TransferProcessor.processMj(obj);
		} else if(obj instanceof JoinRoomMsg) {
			TransferProcessor.processMj(obj);
		} else if(obj instanceof ReJoinRoomMsg) {
			TransferProcessor.processMj(obj);
		}
	}
}
