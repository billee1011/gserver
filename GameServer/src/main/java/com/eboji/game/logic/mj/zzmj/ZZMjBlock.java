package com.eboji.game.logic.mj.zzmj;

import java.io.Serializable;

public class ZZMjBlock implements Serializable {
	private static final long serialVersionUID = -6753207857835342162L;
	
	private Byte first;
	
	private ZZMJBlockType type;
	
	public Byte getFirst() {
		return first;
	}
	public void setFirst(Byte first) {
		this.first = first;
	}
	public ZZMJBlockType getType() {
		return type;
	}
	public void setType(ZZMJBlockType type) {
		this.type = type;
	}
}
