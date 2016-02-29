package com.eboji.model.common;

public enum ServerInfo {
	SRV_AGENT("1000|代理服务"),		//代理服务
	SRV_LOGIN("1001|登录服务"),		//登录服务
	SRV_GAME("1002|游戏服务"),		//游戏服务
	SRV_CENTER("1003|中心服务"),		//中心服务
	SRV_DATA("1004|数据服务"),		//数据服务
	SRV_IM("1005|消息服务");			//文件服务
	
	private String serverName;
	private int serverCode;
	
	ServerInfo(String info) {
		String[] serverInfo = info.split("\\|");
		this.serverCode = Integer.parseInt(serverInfo[0]);
		this.serverName = serverInfo[1];
	}
	
	public int serverCode() {
		return this.serverCode;
	}
	
	public String serverName() {
		return this.serverName;
	}
}
