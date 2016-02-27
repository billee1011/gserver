package com.eboji.model.message;

import java.io.Serializable;

import com.eboji.model.common.MsgType;

public abstract class BaseMsg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private MsgType t;
	
	//client唯一标识id(登录前是手机标识符,登录后是用户id)
	private String cid;
	
	//游戏id
	private String gid;
	
	//用户id
	private String uid;

	public MsgType getT() {
		return t;
	}

	public void setT(MsgType t) {
		this.t = t;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}
