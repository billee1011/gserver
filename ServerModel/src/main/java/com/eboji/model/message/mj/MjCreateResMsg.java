package com.eboji.model.message.mj;

import com.eboji.model.common.MsgType;

public class MjCreateResMsg extends MjBaseMsg {
	private static final long serialVersionUID = -8748455784910034492L;
	
	public MjCreateResMsg() {
		super();
		setT(MsgType.MJ_CREATERES);
	}
	
	private String remoteAddress;

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
}
