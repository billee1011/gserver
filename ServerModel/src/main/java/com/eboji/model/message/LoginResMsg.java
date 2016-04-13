package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class LoginResMsg extends BaseMsg {
	private static final long serialVersionUID = 3317339761729960477L;
	
	public LoginResMsg() {
		super();
		setT(MsgType.LOGINRES);
	}
	
	private String username;
	
	private String status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
