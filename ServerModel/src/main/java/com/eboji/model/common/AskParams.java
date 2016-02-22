package com.eboji.model.common;

import java.io.Serializable;

public class AskParams implements Serializable {
	private static final long serialVersionUID = -5896668544476463102L;
	
	private String auth;

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
}
