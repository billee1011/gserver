package com.eboji.commons.type;

import com.eboji.commons.Constant;

/**
 * 消息类型Enum类
 * @author zhoucl 2016-02-19
 */
public enum MsgType {
	PING("PingMsg"),						//网络检测PING消息
	
	LOGIN("LoginMsg"),						//登录请求消息
	LOGINRES("LoginResMsg"),				//响应登录消息
	
	LOGOUT("LogoutMsg"),					//登出请求消息
	LOGOUTRES("LogoutResMsg"),				//响应登出消息
	
	CONN("ConnMsg"),				        //服务之间建立TCP请求消息
	CONNRES("ConnResMsg"),					//服务之间建立TCP请求响应消息
	
	REG("RegisterMsg"),				        //各服务向中心服务注册请求消息
	REGRES("RegisterResMsg"),				//中心服务相应注册请求的消息
	
	CREATEROOM("CreateRoomMsg"), 			//创建房间
	CREATEROOMRES("CreateRoomResMsg"),		//创建房间响应消息
	JOINROOM("JoinRoomMsg"),		        //加入房间
	JOINROOMRES("JoinRoomResMsg"),			//加入房间响应消息
	JOINROOMNOMEM("JoinRoomNoMemMsg"),		//加入房间缓存失效消息
	JOINROOMNOMEMRES("JoinRoomNoMemResMsg"),//加入房间缓存失效获取游戏服务地址返回消息
	REJOINROOM("ReJoinRoomMsg"),			//重新加入房间
	
	/** 麻将类消息定义开始 **/
	MJ_START("MjStartMsg"),					//麻将游戏开始消息
	MJ_DEAL("MjDealMsg"),					//发牌
	MJ_HU("MjHuMsg"),						//胡牌
	MJ_CHI("MjChiMsg"),						//吃牌
	MJ_PENG("MjPengMsg"),					//碰牌
	MJ_GANG("MjGangMsg"),					//杠牌
	MJ_GUO("MjGuoMsg"),						//过牌
	MJ_GET("MjGetMsg"),						//摸牌
	MJ_ENDEMPTY("MjEndEmptyMsg"),			//流局
	MJ_END("MjEndMsg"),						//游戏结束
	/** 麻将类消息定义结束 **/
	
	/**
	 * 数据服务类消息定义
	 */

	ASK("AskMsg"),
	 
	REPLY2SERVER("ReplyToServerMsg"),
	REPLY2CLIENT("ReplyToClientMsg");
	
	private static final String PKG = "com.eboji.commons.msg";
	
	private String clazz;
	
	public String getClazz() {
		String midStr = "";
		if(this.toString().contains(Constant.STR_UNDERLINE)) {
			String[] midPkgs = this.toString().split(Constant.STR_UNDERLINE);
			for(int i = 0; i < midPkgs.length - 1; i++) {
				midStr += midPkgs[i].toLowerCase() + Constant.STR_DOT;
			}
		}
		
		return PKG + Constant.STR_DOT + midStr + clazz;
	}

	private MsgType(String clazz) {
		this.clazz = clazz;
	}
}
