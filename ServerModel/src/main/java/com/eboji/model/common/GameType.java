package com.eboji.model.common;


public enum GameType {
	MJ_ZZMJ("1000|转转麻将"),
	MJ_CSMJ("1001|长沙麻将"),
	MJ_YYMJ("1002|益阳麻将"),
	MJ_CDMJ("1003|常德麻将"),
	MJ_LYMJ("1004|浏阳麻将"),
	
	ZP_DDZ("2000|斗地主"),
	ZP_PDK("2001|跑得快"),
	ZP_ZJH("2002|炸金花")
	;
	
	private String desc;
	
	private GameType(String desc) {
		this.desc = desc;
	}
	
	public Integer getID() {
		return Integer.parseInt(desc.substring(0, 4));
	}
	
	public String getName() {
		return desc.substring(5);
	}
	
	public static void main(String[] args) {
		System.out.println(GameType.MJ_CSMJ.getID());
		System.out.println(GameType.MJ_ZZMJ.getName());
	}
}
