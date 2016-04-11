package com.eboji.persist.pojo;

import java.math.BigDecimal;

public class GcRatioTax {
    private Integer id;

    private Integer type;

    private BigDecimal taxratio;

    private Integer status;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getTaxratio() {
        return taxratio;
    }

    public void setTaxratio(BigDecimal taxratio) {
        this.taxratio = taxratio;
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