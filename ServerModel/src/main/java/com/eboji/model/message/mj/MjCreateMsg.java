package com.eboji.model.message.mj;

import com.eboji.model.common.MsgType;

public class MjCreateMsg extends MjBaseMsg {
	private static final long serialVersionUID = 5665023124426065521L;
	
	public MjCreateMsg() {
		super();
		setT(MsgType.MJ_CREATE);
	}
}
