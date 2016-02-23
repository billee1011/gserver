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
	
	//状态值
	public static final String STATUS_SUCCESS	="SUCCESS";
	public static final String STATUS_FAILED	="FAILED";
	
	//服务类型编码
	public static final Integer SRV_AGENT		= 0x3E8;		//代理服务
	public static final Integer SRV_LOGIN		= 0x3E9;		//登录服务
	public static final Integer SRV_GAME		= 0x3EA;		//游戏服务
	public static final Integer SRV_CENTER		= 0x3EB;		//中心服务
	public static final Integer SRV_DATA		= 0x3EC;		//数据服务
	public static final Integer SRV_FILE		= 0x3ED;		//文件服务
	
	//游戏类型编码
	//麻将类型
	public static final Integer GAME_MJ_ZZ		= 0x2710;		//转转麻将
	public static final Integer GAME_MJ_CS		= 0x2711;		//长沙麻将
	
}
