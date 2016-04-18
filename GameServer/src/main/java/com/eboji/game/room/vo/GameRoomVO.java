package com.eboji.game.room.vo;

import java.util.Map;

public class GameRoomVO {
	//房间号
	private int roomNo;
	//游戏id
	private String gid;
	//用户id和tcp的remote
	private Map<String, String> uMap;
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Map<String, String> getuMap() {
		return uMap;
	}
	public void setuMap(Map<String, String> uMap) {
		this.uMap = uMap;
	}
	@Override
	public String toString() {
		return "GameRoomVO [roomNo=" + roomNo + ", gid=" + gid + ", uMap="
				+ uMap + "]";
	}
}
