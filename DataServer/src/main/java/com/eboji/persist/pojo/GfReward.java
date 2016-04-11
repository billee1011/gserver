package com.eboji.persist.pojo;

import java.math.BigDecimal;

public class GfReward {
    private Long id;

    private Integer uid;

    private Integer type;

    private BigDecimal rewardmoney;

    private BigDecimal rewardmoneytax;

    private Integer rewardcoin;

    private Integer rewardcointax;

    private Integer status;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getRewardmoney() {
        return rewardmoney;
    }

    public void setRewardmoney(BigDecimal rewardmoney) {
        this.rewardmoney = rewardmoney;
    }

    public BigDecimal getRewardmoneytax() {
        return rewardmoneytax;
    }

    public void setRewardmoneytax(BigDecimal rewardmoneytax) {
        this.rewardmoneytax = rewardmoneytax;
    }

    public Integer getRewardcoin() {
        return rewardcoin;
    }

    public void setRewardcoin(Integer rewardcoin) {
        this.rewardcoin = rewardcoin;
    }

    public Integer getRewardcointax() {
        return rewardcointax;
    }

    public void setRewardcointax(Integer rewardcointax) {
        this.rewardcointax = rewardcointax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}