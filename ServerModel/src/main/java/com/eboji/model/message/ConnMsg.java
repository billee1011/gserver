package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class ConnMsg extends BaseMsg {
	private static final long serialVersionUID = -2793779374565837760L;
	
	public ConnMsg() {
		super();
		setT(MsgType.CONN);
	}
}
