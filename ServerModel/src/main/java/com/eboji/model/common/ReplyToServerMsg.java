package com.eboji.model.common;

import com.eboji.model.message.BaseMsg;

public class ReplyToServerMsg extends BaseMsg {
	private static final long serialVersionUID = -2995788072768571438L;
	
	public ReplyToServerMsg() {
		super();
		setT(MsgType.REPLY2SERVER);
	}
	
	private ReplyServerBody body;

	public ReplyServerBody getBody() {
		return body;
	}

	public void setBody(ReplyServerBody body) {
		this.body = body;
	}
}
