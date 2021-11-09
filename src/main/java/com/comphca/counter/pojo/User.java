package com.comphca.counter.pojo;

public class User {
    private Integer id;

    private Long uid;

    private String password;

    private Long balance;

    private String createdate;

    private String createtime;

    private Integer modifydate;

    private Integer modifytime;

    private String token;

    public User(Integer id, Long uid, String password, Long balance, String createdate, String createtime, Integer modifydate, Integer modifytime, String token) {
        this.id = id;
        this.uid = uid;
        this.password = password;
        this.balance = balance;
        this.createdate = createdate;
        this.createtime = createtime;
        this.modifydate = modifydate;
        this.modifytime = modifytime;
        this.token = token;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getModifydate() {
        return modifydate;
    }

    public void setModifydate(Integer modifydate) {
        this.modifydate = modifydate;
    }

    public Integer getModifytime() {
        return modifytime;
    }

    public void setModifytime(Integer modifytime) {
        this.modifytime = modifytime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}