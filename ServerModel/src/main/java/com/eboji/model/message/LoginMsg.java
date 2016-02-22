package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class LoginMsg extends BaseMsg {
	private static final long serialVersionUID = -6698914408436238691L;
	
	private String username;
	
	private String password;
	
	public LoginMsg() {
		super();
		setT(MsgType.LOGIN);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
