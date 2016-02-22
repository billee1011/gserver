package com.eboji.model.common;

import com.eboji.model.constant.Constant;

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
	
	QNOTICE("QNoticeMsg"),					//查询系统通知消息
	QNOTICERES("QNoticeMsg"),				//响应查询系统通知消息
	
	CROOM("CreateRoomMsg"),					//创建房间请求消息
	CROOMRES("CreateRoomResMsg"),			//响应创建房间消息
	
	JOINGAME("JoinGameMsg"),				//加入房间请求消息
	JOINGAMERES("JoinGameResMsg"),			//响应加入房间消息
	
	GSTART("GameStartMsg"),					//游戏开始请求消息
	GSTARTRES("GameStartResMsg"),			//响应游戏开始消息
	
	GPLAY("GamePlayMsg"),					//出牌请求消息
	GPLAYRES("GamePlayResMsg"),				//响应出牌请求消息
	
	GDRAWRES("GameDrawMsg"),				//摸牌响应消息
	
	GPLAYPENG("GamePlayPengMsg"),			//碰牌请求消息
	GPLAYPENGRES("GamePlayPengResMsg"),		//响应碰牌消息
	
	GPLAYGANG("GamePlayGangMsg"),			//杠牌请求消息
	GPLAYGANGRES("GamePlayGangResMsg"),		//响应杠牌消息
	
	GPLAYHU("GamePlayHuMsg"),				//胡牌请求消息
	GPLAYHURES("GamePlayHuResMsg"),			//响应胡牌消息
	
	GPLAYCHI("GamePlayChiMsg"),				//吃牌请求消息
	GPLAYCHIRES("GamePlayChiResMsg"),		//响应吃牌消息
	
	CONN("ConnMsg"),						//服务之间建立TCP请求消息
	CONNRES("ConnResMsg"),					//服务之间建立TCP请求响应消息
	
	ASK("AskMsg"),
	 
	REPLY2SERVER("ReplyToServerMsg"),
	REPLY2CLIENT("ReplyToClientMsg");
	
	private static final String PKG = "com.eboji.model.message";
	
	private String clazz;
	
	public String getClazz() {
		return PKG + Constant.STR_DOT + clazz;
	}

	private MsgType(String clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return getClazz();
	}
}
