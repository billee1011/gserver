package com.eboji.model.message.mj;

import com.eboji.model.message.BaseMsg;

public class MjBaseMsg extends BaseMsg {
	private static final long serialVersionUID = 7194608791826682226L;

	public MjBaseMsg() {
		super();
	}
	
	public String deskId;

	public String getDeskId() {
		return deskId;
	}

	public void setDeskId(String deskId) {
		this.deskId = deskId;
	}
}
