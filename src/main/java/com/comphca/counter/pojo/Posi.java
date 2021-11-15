package com.comphca.counter.pojo;

public class Posi {
    private Integer id;

    private Long uid;

    private Integer code;

    private Long cost;

    private Long count;

    public Posi(Integer id, Long uid, Integer code, Long cost, Long count) {
        this.id = id;
        this.uid = uid;
        this.code = code;
        this.cost = cost;
        this.count = count;
    }

    public Posi() {
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

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}