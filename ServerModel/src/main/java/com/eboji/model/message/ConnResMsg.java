package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class ConnResMsg extends BaseMsg {
	private static final long serialVersionUID = -2793779374565837760L;
	
	public ConnResMsg() {
		super();
		setT(MsgType.CONNRES);
	}
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
