package com.eboji.model.message.mj;

import com.eboji.model.common.MsgType;

public class MjJoinMsg extends MjBaseMsg {
	private static final long serialVersionUID = -3542648936629437725L;
	
	public MjJoinMsg() {
		super();
		setT(MsgType.MJ_JOIN);
	}
}
