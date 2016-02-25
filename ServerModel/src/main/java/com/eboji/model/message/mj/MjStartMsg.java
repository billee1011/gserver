package com.eboji.model.message.mj;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class MjStartMsg extends BaseMsg {
	private static final long serialVersionUID = 2223596824875617104L;
	
	public MjStartMsg() {
		super();
		setT(MsgType.MJ_START);
	}
}
