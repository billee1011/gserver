package com.eboji.persist.pojo;

import java.util.Date;

public class GgHist {
    private Long id;

    private Long roomid;

    private Integer playerid;

    private Integer optype;

    private String opcard;

    private String incard;

    private String outcard;

    private Integer round;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public Integer getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Integer playerid) {
        this.playerid = playerid;
    }

    public Integer getOptype() {
        return optype;
    }

    public void setOptype(Integer optype) {
        this.optype = optype;
    }

    public String getOpcard() {
        return opcard;
    }

    public void setOpcard(String opcard) {
        this.opcard = opcard == null ? null : opcard.trim();
    }

    public String getIncard() {
        return incard;
    }

    public void setIncard(String incard) {
        this.incard = incard == null ? null : incard.trim();
    }

    public String getOutcard() {
        return outcard;
    }

    public void setOutcard(String outcard) {
        this.outcard = outcard == null ? null : outcard.trim();
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}