package com.eboji.game.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.game.room.GameRoomAccess;
import com.eboji.game.room.GameServerCfgMap;
import com.eboji.game.room.impl.GameRoomAccessImpl;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.CreateRoomMsg;
import com.eboji.model.message.JoinRoomMsg;

public class GameServerProcessor {
	private static final Logger logger = LoggerFactory.getLogger(GameServerProcessor.class);
	
	private GameRoomAccess gameRoomAccess = null;
	
	public GameServerProcessor() {
		try {
			gameRoomAccess = new GameRoomAccessImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//游戏逻辑处理入口分发类
	public void process(MemCacheClient client, BaseMsg obj, String remoteAddress) {
		logger.debug("游戏逻辑处理开始");
		
		if(obj instanceof CreateRoomMsg) {
			//创建房间处理逻辑
			CreateRoomMsg createMsg = (CreateRoomMsg)obj;
			createMsg.setRas(remoteAddress);
			gameRoomAccess.createRoomFunc(client, obj);
		} else if(obj instanceof JoinRoomMsg) {
			//加入房间处理逻辑
			JoinRoomMsg joinMsg = (JoinRoomMsg)obj;
			joinMsg.setRas(remoteAddress);
			gameRoomAccess.joinRoonFunc(client, obj);
		} else {
			//游戏处理逻辑总开关
			GameServerCfgMap.getGameManager().process(obj);
		}
	}
}
