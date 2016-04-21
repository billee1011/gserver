package com.eboji.game.room.impl;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.game.room.GameRoomAccess;
import com.eboji.game.server.transfer.facade.TransferFacade;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.CreateRoomMsg;
import com.eboji.model.message.JoinRoomMsg;

public class GameRoomAccessImpl implements GameRoomAccess {
	@Override
	public void createRoomFunc(MemCacheClient client, BaseMsg obj) {
		if(obj instanceof CreateRoomMsg) {
			CreateRoomMsg mjMsg = (CreateRoomMsg)obj;
			TransferFacade.facade(mjMsg);
		}
	}

	@Override
	public void joinRoonFunc(MemCacheClient client, BaseMsg obj) {
		if(obj instanceof JoinRoomMsg) {
			JoinRoomMsg msg = (JoinRoomMsg)obj;
			TransferFacade.facade(msg);
 		}
	}

	@Override
	public void joinLiveRoomFunc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dismissRoomFunc() {
		// TODO Auto-generated method stub
		
	}
}
