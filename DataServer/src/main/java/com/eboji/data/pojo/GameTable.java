package com.eboji.data.pojo;

import java.util.Date;

public class GameTable {
    private Integer id;

    private Integer euid;

    private Integer suid;

    private Integer wuid;

    private Integer nuid;

    private Integer gid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEuid() {
        return euid;
    }

    public void setEuid(Integer euid) {
        this.euid = euid;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    public Integer getWuid() {
        return wuid;
    }

    public void setWuid(Integer wuid) {
        this.wuid = wuid;
    }

    public Integer getNuid() {
        return nuid;
    }

    public void setNuid(Integer nuid) {
        this.nuid = nuid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}