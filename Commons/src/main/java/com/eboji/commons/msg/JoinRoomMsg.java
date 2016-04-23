package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class JoinRoomMsg extends BaseMsg {
	private static final long serialVersionUID = -3542648936629437725L;
	
	public JoinRoomMsg() {
		super();
		setT(MsgType.JOINROOM);
	}
}
