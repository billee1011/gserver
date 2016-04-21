package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class CreateRoomResMsg extends BaseMsg {
	private static final long serialVersionUID = -8748455784910034492L;
	
	public CreateRoomResMsg() {
		super();
		setT(MsgType.CREATEROOMRES);
	}
}
