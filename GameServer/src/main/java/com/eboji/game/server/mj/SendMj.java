package com.eboji.game.server.mj;

import java.io.Serializable;
import java.util.Arrays;

public class SendMj implements Serializable {
	private static final long serialVersionUID = -8961511484612313344L;
	private Integer mjCount;
	private Byte[] mjHand;
	private Boolean isHu;
	private Boolean isGang;
	public Integer getMjCount() {
		return mjCount;
	}
	public void setMjCount(Integer mjCount) {
		this.mjCount = mjCount;
	}
	public Byte[] getMjHand() {
		return mjHand;
	}
	public void setMjHand(Byte[] mjHand) {
		this.mjHand = mjHand;
	}
	public Boolean getIsHu() {
		return isHu;
	}
	public void setIsHu(Boolean isHu) {
		this.isHu = isHu;
	}
	public Boolean getIsGang() {
		return isGang;
	}
	public void setIsGang(Boolean isGang) {
		this.isGang = isGang;
	}
	@Override
	public String toString() {
		return "SendMj [mjCount=" + mjCount + ", mjHand="
				+ Arrays.toString(mjHand) + ", isHu=" + isHu + ", isGang="
				+ isGang + "]";
	}
}
