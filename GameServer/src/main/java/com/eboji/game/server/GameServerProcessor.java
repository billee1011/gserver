package com.eboji.game.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.game.bootstrap.Daemon;

public class GameServerProcessor {
	private static final Logger logger = LoggerFactory.getLogger(GameServerProcessor.class);
	
	public GameServerProcessor() {}
	
	//游戏逻辑处理入口分发类
	public void process(BaseMsg obj, String remoteAddress) {
		logger.debug("游戏逻辑处理开始");
		
		if(obj instanceof CreateRoomMsg) {
			//创建房间处理逻辑
			CreateRoomMsg createMsg = (CreateRoomMsg)obj;
			createMsg.setRas(remoteAddress);
			createMsg.setGamePort(Daemon.getInstance().getPort());
			GameServerCfgMap.getGameManager().createRoomFunc(obj);
		} else if(obj instanceof JoinRoomMsg) {
			//加入房间处理逻辑
			JoinRoomMsg joinMsg = (JoinRoomMsg)obj;
			joinMsg.setRas(remoteAddress);
			GameServerCfgMap.getGameManager().joinRoonFunc(obj);
		} else {
			//游戏处理逻辑总开关
			GameServerCfgMap.getGameManager().process(obj);
		}
	}
}
