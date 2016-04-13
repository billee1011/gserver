package com.eboji.model.message.mj;

import com.eboji.model.common.MsgType;

public class MjJoinResMsg extends MjBaseMsg {
	private static final long serialVersionUID = -5516718806582360190L;

	public MjJoinResMsg() {
		super();
		setT(MsgType.MJ_JOINRES);
	}
	
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
