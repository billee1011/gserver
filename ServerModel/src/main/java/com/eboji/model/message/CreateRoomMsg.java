package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class CreateRoomMsg extends BaseMsg {
	private static final long serialVersionUID = 5665023124426065521L;
	
	public CreateRoomMsg() {
		super();
		setT(MsgType.CREATEROOM);
	}
	
	public int gameType;
	
	public long gamePrice;
	
	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public long getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(long gamePrice) {
		this.gamePrice = gamePrice;
	}
}
