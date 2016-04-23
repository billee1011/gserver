package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class LoginMsg extends BaseMsg {
	private static final long serialVersionUID = -6698914408436238691L;
	
	private String username;
	
	private String password;
	
	private String nickname;
	
	private String iconB64;
	
	private String iconurl;
	
	private String ip;
	
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIconB64() {
		return iconB64;
	}

	public void setIconB64(String iconB64) {
		this.iconB64 = iconB64;
	}

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
