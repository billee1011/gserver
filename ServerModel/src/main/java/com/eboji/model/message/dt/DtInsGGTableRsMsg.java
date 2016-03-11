package com.eboji.model.message.dt;

import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DtInsGGTableRsMsg extends BaseMsg {
	private static final long serialVersionUID = 9222357902702048710L;
	
	public DtInsGGTableRsMsg() {
		super();
		setT(MsgType.DT_INSGGTABLERS);
	}
	
	private int deskId;
	
	private int position;

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
