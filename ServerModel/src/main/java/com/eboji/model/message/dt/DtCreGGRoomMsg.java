package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtCreGGRoomMsg extends BaseMsg {
	private static final long serialVersionUID = -7032019248281449077L;
	
	public DtCreGGRoomMsg() {
		super();
		setT(MsgType.DT_CREGGROOM);
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
