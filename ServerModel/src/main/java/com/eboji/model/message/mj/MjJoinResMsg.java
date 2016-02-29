package com.eboji.model.message.mj;

import com.eboji.model.common.MsgType;

public class MjJoinResMsg extends MjBaseMsg {
	private static final long serialVersionUID = 7055555370977867162L;
	
	public MjJoinResMsg() {
		super();
		setT(MsgType.MJ_JOINRES);
	}
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
