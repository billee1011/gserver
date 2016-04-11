package com.eboji.model.message.mj;

import com.eboji.model.message.BaseMsg;

public class MjBaseMsg extends BaseMsg {
	private static final long serialVersionUID = 7194608791826682226L;

	public MjBaseMsg() {
		super();
	}
	
	private int roomNo;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
}
