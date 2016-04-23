package com.eboji.commons.msg;

import java.util.Map;
import java.util.Set;

import com.eboji.commons.type.MsgType;

public class RegisterResMsg extends BaseMsg {
	private static final long serialVersionUID = -503142815130135893L;
	
	public RegisterResMsg() {
		super();
		
		setT(MsgType.REGRES);
	}
	
	private String status;
	
	private Map<String, Set<String>> serviceMap;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, Set<String>> getServiceMap() {
		return serviceMap;
	}

	public void setServiceMap(Map<String, Set<String>> serviceMap) {
		this.serviceMap = serviceMap;
	}

	@Override
	public String toString() {
		return "RegisterResMsg [status=" + status + ", serviceMap=" + serviceMap + "]";
	}
}
