package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtCreGGRoomMsg extends BaseMsg {
	private static final long serialVersionUID = -7032019248281449077L;
	
	public DtCreGGRoomMsg() {
		super();
		setT(MsgType.DT_CREGGROOM);
	}
	
	private int position;
	
	public int gameType;
	
	public long gamePrice;
	
	public String remoteAddress;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

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

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
}
