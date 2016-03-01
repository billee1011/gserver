package com.eboji.game.logic.mj.zzmj;

public class ZZMjGang {
	Byte mjGang;		//所杠的牌
	Byte mjGangType;	//杠牌类型:4-暗杠,2-明刚,1-普通杠,0-无杠
	public Byte getMjGang() {
		return mjGang;
	}
	public void setMjGang(Byte mjGang) {
		this.mjGang = mjGang;
	}
	public Byte getMjGangType() {
		return mjGangType;
	}
	public void setMjGangType(Byte mjGangType) {
		this.mjGangType = mjGangType;
	}
}
