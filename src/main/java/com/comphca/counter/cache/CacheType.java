package com.comphca.counter.cache;

/**
 * @Created by comphca
 * @Date 2021/10/17 15:22
 * @Description TODO
 */
public enum CacheType {

    CAPTCHA("captcha:"),

    ACCOUNT("account:"),

    ORDER("order:"),

    TRADE("trade:"),

    POSI("posi:"),
    ;

    private String type;

    CacheType(String type) {
        this.type = type;
    }

    public String type() {
        return this.type;
    }


}

