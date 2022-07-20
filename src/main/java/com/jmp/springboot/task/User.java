package com.jmp.springboot.task;

import java.math.BigDecimal;

public class User {
    private Long id;

    private BigDecimal USD;

    private BigDecimal VND;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getUSD() {
        return USD;
    }

    public void setUSD(BigDecimal USD) {
        this.USD = USD;
    }

    public BigDecimal getVND() {
        return VND;
    }

    public void setVND(BigDecimal VND) {
        this.VND = VND;
    }
}
