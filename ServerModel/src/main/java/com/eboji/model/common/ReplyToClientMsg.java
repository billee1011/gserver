package com.eboji.model.common;

import com.eboji.model.message.BaseMsg;

public class ReplyToClientMsg extends BaseMsg {
	private static final long serialVersionUID = -2995788072768571438L;
	
	public ReplyToClientMsg() {
		super();
		setT(MsgType.REPLY2CLIENT);
	}
	
	private ReplyClientBody body;

	public ReplyClientBody getBody() {
		return body;
	}

	public void setBody(ReplyClientBody body) {
		this.body = body;
	}
}
