package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtCreGGRoomRsMsg extends BaseMsg {
	private static final long serialVersionUID = 9222357902702048710L;
	
	public DtCreGGRoomRsMsg() {
		super();
		setT(MsgType.DT_CREGGROOMRS);
	}
	
	private int roomId;
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
}
