package com.eboji.game.room.impl;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.game.room.GameRoomAccess;
import com.eboji.game.server.transfer.facade.TransferFacade;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.dt.DtCreGGRoomMsg;
import com.eboji.model.message.mj.MjCreateMsg;
import com.eboji.model.message.mj.MjJoinMsg;

public class GameRoomAccessImpl implements GameRoomAccess {
	@Override
	public void createRoomFunc(MemCacheClient client, BaseMsg obj) {
		if(obj instanceof MjCreateMsg) {
			MjCreateMsg mjMsg = (MjCreateMsg)obj;
			DtCreGGRoomMsg msg = new DtCreGGRoomMsg();
			msg.setCid(mjMsg.getCid());
			msg.setGid(mjMsg.getGid());
			msg.setUid(mjMsg.getUid());
			msg.setGamePrice(mjMsg.getGamePrice());
			msg.setGameType(mjMsg.getGameType());
			msg.setRas(mjMsg.getRas());
			TransferFacade.facade(msg);
		}
	}

	@Override
	public void joinRoonFunc(MemCacheClient client, BaseMsg obj) {
		if(obj instanceof MjJoinMsg) {
			MjJoinMsg msg = (MjJoinMsg)obj;
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
