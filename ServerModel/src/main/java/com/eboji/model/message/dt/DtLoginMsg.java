package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtLoginMsg extends BaseMsg {
	private static final long serialVersionUID = -2714709243086986050L;
	
	public DtLoginMsg() {
		super();
		setT(MsgType.DT_LOGIN);
	}
	
	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
