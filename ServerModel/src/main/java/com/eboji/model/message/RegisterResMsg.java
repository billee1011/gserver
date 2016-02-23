package com.eboji.model.message;

import com.eboji.model.common.MsgType;

public class RegisterResMsg extends BaseMsg {
	private static final long serialVersionUID = -503142815130135893L;
	
	public RegisterResMsg() {
		super();
		
		setT(MsgType.REGRES);
	}
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
