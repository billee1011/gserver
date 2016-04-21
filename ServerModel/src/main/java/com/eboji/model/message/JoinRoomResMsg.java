package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class JoinRoomResMsg extends BaseMsg {
	private static final long serialVersionUID = -5516718806582360190L;

	public JoinRoomResMsg() {
		super();
		setT(MsgType.JOINROOMRES);
	}
	
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
