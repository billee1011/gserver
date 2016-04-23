package com.eboji.game.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.game.server.GameServerCfgMap;

public class DefaultGameServerManager extends GameServerManager {
	private static final Logger logger = 
			LoggerFactory.getLogger(DefaultGameServerManager.class);
	
	@Override
	public void process(BaseMsg obj) {
		logger.info("游戏服务管理处理开始");
		
		GameServerCfgMap.getGameMap().get(
			Integer.parseInt(obj.getGid())).process(obj);
	}
}
