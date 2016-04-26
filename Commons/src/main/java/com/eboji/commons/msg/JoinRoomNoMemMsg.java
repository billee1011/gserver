package com.eboji.commons.msg;

import com.eboji.commons.type.MsgType;

public class JoinRoomNoMemMsg extends BaseMsg {
	private static final long serialVersionUID = 864593678204355192L;
	
	public JoinRoomNoMemMsg() {
		super();
		setT(MsgType.JOINROOMNOMEM);
	}
}
