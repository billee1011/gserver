package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class ReJoinRoomMsg extends BaseMsg {
	private static final long serialVersionUID = -3542648936629437725L;
	
	public ReJoinRoomMsg() {
		super();
		setT(MsgType.REJOINROOM);
	}
	
	private String gameHost;

	public String getGameHost() {
		return gameHost;
	}

	public void setGameHost(String gameHost) {
		this.gameHost = gameHost;
	}
}
