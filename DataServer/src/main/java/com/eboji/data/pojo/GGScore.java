package com.eboji.data.pojo;

import java.util.Date;

public class GGScore {
    private Integer id;

    private Integer tid;

    private Integer gno;

    private Integer scEuid;

    private Integer scSuid;

    private Integer scWuid;

    private Integer scNuid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getGno() {
        return gno;
    }

    public void setGno(Integer gno) {
        this.gno = gno;
    }

    public Integer getScEuid() {
        return scEuid;
    }

    public void setScEuid(Integer scEuid) {
        this.scEuid = scEuid;
    }

    public Integer getScSuid() {
        return scSuid;
    }

    public void setScSuid(Integer scSuid) {
        this.scSuid = scSuid;
    }

    public Integer getScWuid() {
        return scWuid;
    }

    public void setScWuid(Integer scWuid) {
        this.scWuid = scWuid;
    }

    public Integer getScNuid() {
        return scNuid;
    }

    public void setScNuid(Integer scNuid) {
        this.scNuid = scNuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}