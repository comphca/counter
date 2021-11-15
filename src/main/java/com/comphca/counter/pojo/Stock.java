package com.comphca.counter.pojo;

import lombok.AllArgsConstructor;


public class Stock {
    private Integer code;

    private String name;

    private String abbrname;

    private Integer status;

    public Stock(Integer code, String name, String abbrname, Integer status) {
        this.code = code;
        this.name = name;
        this.abbrname = abbrname;
        this.status = status;
    }

    public Stock(Integer code, String name, String abbrname){
        this.code = code;
        this.name = name;
        this.abbrname = abbrname;
    }

    public Stock() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbbrname() {
        return abbrname;
    }

    public void setAbbrname(String abbrname) {
        this.abbrname = abbrname == null ? null : abbrname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}