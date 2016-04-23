package com.eboji.game.manager;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.game.server.transfer.TransferFacade;

public abstract class GameServerManager {
	/**
	 * 创建房间
	 */
	public void createRoomFunc(BaseMsg obj) {
		if(obj instanceof CreateRoomMsg) {
			CreateRoomMsg mjMsg = (CreateRoomMsg)obj;
			TransferFacade.facade(mjMsg);
		}
	}
	
	/**
	 * 加入房间
	 */
	public void joinRoonFunc(BaseMsg obj) {
		if(obj instanceof JoinRoomMsg) {
			JoinRoomMsg msg = (JoinRoomMsg)obj;
			TransferFacade.facade(msg);
 		}
	}
	
	/**
	 * 加入直播房间
	 */
	public void joinLiveRoomFunc() {
		
	}

	/**
	 * 解散房间
	 */
	public void dismissRoomFunc() {
		
	}
	
	public abstract void process(BaseMsg obj);
}
