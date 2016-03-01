package com.eboji.game.logic.mj.zzmj;

public class ZZMjData {
	private String uId;
	private Byte[] mjHand;
	private Byte mjTouch;
	private boolean mjHu;
	private boolean mjGang;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public Byte[] getMjHand() {
		return mjHand;
	}
	public void setMjHand(Byte[] mjHand) {
		this.mjHand = mjHand;
	}
	public Byte getMjTouch() {
		return mjTouch;
	}
	public void setMjTouch(Byte mjTouch) {
		this.mjTouch = mjTouch;
	}
	public boolean isMjHu() {
		return mjHu;
	}
	public void setMjHu(boolean mjHu) {
		this.mjHu = mjHu;
	}
	public boolean isMjGang() {
		return mjGang;
	}
	public void setMjGang(boolean mjGang) {
		this.mjGang = mjGang;
	}
}
