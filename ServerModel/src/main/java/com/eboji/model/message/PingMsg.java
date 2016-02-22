package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class PingMsg extends BaseMsg {
	private static final long serialVersionUID = -7184522341085372445L;
	
	public PingMsg() {
		super();
		setT(MsgType.PING);
	}
}
