package com.eboji.game.room;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.eboji.game.room.vo.GameRoomVO;

public class GameRoomMap {
	private static Map<Integer, GameRoomVO> roomMap = new ConcurrentHashMap<Integer, GameRoomVO>();

	public static Map<Integer, GameRoomVO> getRoomMap() {
		return roomMap;
	}
}
