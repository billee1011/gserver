package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class PingMsg extends BaseMsg {
	private static final long serialVersionUID = -7184522341085372445L;
	
	public PingMsg() {
		super();
		setT(MsgType.PING);
	}
	
	private int cport;		//各服务端口号
	
	private String type;

	public int getCport() {
		return cport;
	}

	public void setCport(int cport) {
		this.cport = cport;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
