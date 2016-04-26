package com.eboji.game.manager;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.commons.msg.JoinRoomNoMemMsg;
import com.eboji.game.server.transfer.TransferFacade;

public abstract class GameServerManager {
	/**
	 * 创建房间
	 */
	public void createRoomFunc(CreateRoomMsg obj) {
		TransferFacade.facade(obj);
	}
	
	/**
	 * 加入房间
	 */
	public void joinRoonFunc(JoinRoomMsg obj) {
		TransferFacade.facade(obj);
	}
	
	/**
	 * 获取创建房间的游戏服务
	 */
	public void getGameServerInfo(JoinRoomNoMemMsg obj) {
		TransferFacade.facade(obj);
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
