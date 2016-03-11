package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtInsGGTableMsg extends BaseMsg {
	private static final long serialVersionUID = -7032019248281449077L;
	
	public DtInsGGTableMsg() {
		super();
		setT(MsgType.DT_INSGGTABLE);
	}
	
	private int position;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
