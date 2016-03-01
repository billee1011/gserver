package com.eboji.data.pojo;

public class GGHist {
    private Integer id;

    private Integer tid;

    private Integer gno;

    private String dEuid;

    private String dSuid;

    private String dWuid;

    private String dNuid;

    private String dIn;

    private String dOut;

    private Integer type;

    private Integer step;

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

    public String getdEuid() {
        return dEuid;
    }

    public void setdEuid(String dEuid) {
        this.dEuid = dEuid == null ? null : dEuid.trim();
    }

    public String getdSuid() {
        return dSuid;
    }

    public void setdSuid(String dSuid) {
        this.dSuid = dSuid == null ? null : dSuid.trim();
    }

    public String getdWuid() {
        return dWuid;
    }

    public void setdWuid(String dWuid) {
        this.dWuid = dWuid == null ? null : dWuid.trim();
    }

    public String getdNuid() {
        return dNuid;
    }

    public void setdNuid(String dNuid) {
        this.dNuid = dNuid == null ? null : dNuid.trim();
    }

    public String getdIn() {
        return dIn;
    }

    public void setdIn(String dIn) {
        this.dIn = dIn == null ? null : dIn.trim();
    }

    public String getdOut() {
        return dOut;
    }

    public void setdOut(String dOut) {
        this.dOut = dOut == null ? null : dOut.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}