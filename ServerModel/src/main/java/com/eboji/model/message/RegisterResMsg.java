package com.eboji.model.message;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eboji.model.common.MsgType;

public class RegisterResMsg extends BaseMsg {
	private static final long serialVersionUID = -503142815130135893L;
	
	public RegisterResMsg() {
		super();
		
		setT(MsgType.REGRES);
	}
	
	private String status;
	
	private Map<Integer, Set<String>> serviceMap;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<Integer, Set<String>> getServiceMap() {
		return serviceMap;
	}

	public void setServiceMap(Map<Integer, Set<String>> serviceMap) {
		this.serviceMap = serviceMap;
	}
}
