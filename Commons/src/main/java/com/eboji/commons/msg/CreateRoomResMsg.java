package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class CreateRoomResMsg extends BaseMsg {
	private static final long serialVersionUID = -8748455784910034492L;
	
	public CreateRoomResMsg() {
		super();
		setT(MsgType.CREATEROOMRES);
	}
}
