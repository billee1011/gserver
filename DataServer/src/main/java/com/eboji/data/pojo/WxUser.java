package com.eboji.data.pojo;

public class WxUser {
    private Integer id;

    private String wxcode;

    private String wxnick;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxcode() {
        return wxcode;
    }

    public void setWxcode(String wxcode) {
        this.wxcode = wxcode == null ? null : wxcode.trim();
    }

    public String getWxnick() {
        return wxnick;
    }

    public void setWxnick(String wxnick) {
        this.wxnick = wxnick == null ? null : wxnick.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}