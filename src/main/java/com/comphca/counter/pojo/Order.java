package com.comphca.counter.pojo;

import lombok.Builder;

@Builder
public class Order {
    private Integer id;

    private Long uid;

    private Integer code;

    private Integer direction;

    private Integer type;

    private Long price;

    private Long ocount;

    private Integer status;

    private String date;

    private String time;

    public Order(Integer id, Long uid, Integer code, Integer direction, Integer type, Long price, Long ocount, Integer status, String date, String time) {
        this.id = id;
        this.uid = uid;
        this.code = code;
        this.direction = direction;
        this.type = type;
        this.price = price;
        this.ocount = ocount;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getOcount() {
        return ocount;
    }

    public void setOcount(Long ocount) {
        this.ocount = ocount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}