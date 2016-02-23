package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class LoginResMsg extends BaseMsg {
	private static final long serialVersionUID = 3317339761729960477L;
	
	public LoginResMsg() {
		super();
		setT(MsgType.LOGINRES);
	}
	
	private String userId;
	
	private String status;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
