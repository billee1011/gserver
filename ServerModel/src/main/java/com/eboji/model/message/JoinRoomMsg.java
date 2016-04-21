package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class JoinRoomMsg extends BaseMsg {
	private static final long serialVersionUID = -3542648936629437725L;
	
	public JoinRoomMsg() {
		super();
		setT(MsgType.JOINROOM);
	}
}
