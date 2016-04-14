package com.eboji.model.constant;

public class Constant {
	//基本符号常量
	public static final String STR_DOT          = ".";
	public static final String STR_COMMA        = ",";
	public static final String STR_SEMICOLON    = ";";
	public static final String STR_UNDERLINE    = "_";
	public static final String STR_LINE         = "-";
	public static final String STR_SLASH        = "/";
	public static final String STR_STAR         = "*";
	public static final String STR_AT           = "@";
	public static final String STR_VLINE		= "|";
	public static final String STR_COLON		= ":";
	
	//消息传递中的特定KEY值
	public static final String KEY_TYPE 		= "t";
	public static final String KEY_GID			= "gid";
	public static final String KEY_CID			= "cid";
	public static final String KEY_UID			= "uid";
	
	//状态值
	public static final String STATUS_SUCCESS	="SUCCESS";
	public static final String STATUS_FAILED	="FAILED";
	
	//服务类型编码
	public static final String SRV_AGENT		= "AGENT";		//代理服务(1000)
	public static final String SRV_LOGIN		= "LOGIN";		//登录服务(1001)
	public static final String SRV_GAME	        = "GAME";		//游戏服务(1002)
	public static final String SRV_DATA	        = "DATA";		//数据服务(1003)
	public static final String SRV_IM   	   	= "IM";			//文件服务(1004)
	
	public static final String SRV_CENTER		= "CENTER";		//中心服务(9999)
	
	//游戏类型编码
	//麻将类型
	public static final Integer GAME_MJ_ZZ		= 0x2710;		//转转麻将(10000)
	public static final Integer GAME_MJ_CS		= 0x2711;		//长沙麻将
	
	//游戏类型名称
	public static final String GAME_MJ_ZZ_NAME	= "转转麻将";	//转转麻将	
}
