package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtLogoutMsg extends BaseMsg {
	private static final long serialVersionUID = 6132501958341211870L;

	public DtLogoutMsg() {
		super();
		setT(MsgType.DT_LOGOUT);
	}
}
