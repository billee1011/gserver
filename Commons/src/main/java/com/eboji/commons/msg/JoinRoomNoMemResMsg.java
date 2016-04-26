package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class JoinRoomNoMemResMsg extends BaseMsg {
	private static final long serialVersionUID = -3524776568986741144L;
	
	public JoinRoomNoMemResMsg() {
		super();
		setT(MsgType.JOINROOMNOMEMRES);
	}
	
	private String gameHost;

	public String getGameHost() {
		return gameHost;
	}

	public void setGameHost(String gameHost) {
		this.gameHost = gameHost;
	}
}
