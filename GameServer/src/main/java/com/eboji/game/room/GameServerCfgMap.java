package com.eboji.game.room;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.eboji.game.logic.mj.GameBaseLogic;
import com.eboji.game.manager.GameServerManager;
import com.eboji.game.room.vo.GameRoomVO;

public class GameServerCfgMap {
	/**
	 * 存储房间对应房间中的玩家信息Map
	 */
	private static Map<Integer, GameRoomVO> roomMap = new ConcurrentHashMap<Integer, GameRoomVO>();

	/**
	 * 游戏ID对应的配置游戏逻辑处理类Map
	 */
	private static Map<Integer, GameBaseLogic> gameMap = new HashMap<Integer, GameBaseLogic>();
	
	/**
	 * 游戏总管理类
	 */
	private static GameServerManager gameManager = null;
	
	public static Map<Integer, GameRoomVO> getRoomMap() {
		return roomMap;
	}

	public static Map<Integer, GameBaseLogic> getGameMap() {
		return gameMap;
	}

	public static GameServerManager getGameManager() {
		return gameManager;
	}

	public static void setGameManager(GameServerManager gameManager) {
		GameServerCfgMap.gameManager = gameManager;
	}
}
