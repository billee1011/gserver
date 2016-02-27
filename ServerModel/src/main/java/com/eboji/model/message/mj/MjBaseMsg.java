package com.eboji.model.message.mj;

import com.eboji.model.message.BaseMsg;

public class MjBaseMsg extends BaseMsg {
	private static final long serialVersionUID = 7194608791826682226L;

	public MjBaseMsg() {
		super();
	}
	
	public int deskId;

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
}
