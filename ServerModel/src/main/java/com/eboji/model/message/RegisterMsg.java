package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class RegisterMsg extends BaseMsg {
	private static final long serialVersionUID = -2462554135952791173L;
	
	public RegisterMsg() {
		super();
		setT(MsgType.REG);
	}
	
	private int port;		//中心服务监听端口号
	
	private int cport;		//各服务端口号
	
	private int serverId;	//服务ID号

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getCport() {
		return cport;
	}

	public void setCport(int cport) {
		this.cport = cport;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
}