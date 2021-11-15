package com.comphca.counter.pojo;

public class Trade {
    private Long id;

    private Long uid;

    private Integer code;

    private Integer direction;

    private Long price;

    private Long tcount;

    private Integer oid;

    private String date;

    private String time;

    public Trade(Long id, Long uid, Integer code, Integer direction, Long price, Long tcount, Integer oid, String date, String time) {
        this.id = id;
        this.uid = uid;
        this.code = code;
        this.direction = direction;
        this.price = price;
        this.tcount = tcount;
        this.oid = oid;
        this.date = date;
        this.time = time;
    }

    public Trade() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTcount() {
        return tcount;
    }

    public void setTcount(Long tcount) {
        this.tcount = tcount;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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