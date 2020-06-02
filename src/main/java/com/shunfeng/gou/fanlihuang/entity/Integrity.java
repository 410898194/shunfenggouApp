package com.shunfeng.gou.fanlihuang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Integrity {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String userid;

    /**
     *
     */
    private Integer orderid;

    /**
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date changetime;

    /**
     *
     */
    private Integer changenum;

    /**
     *
     */
    private String triggertype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getChangetime() {
        return changetime;
    }

    public void setChangetime(Date changetime) {
        this.changetime = changetime;
    }

    public Integer getChangenum() {
        return changenum;
    }

    public void setChangenum(Integer changenum) {
        this.changenum = changenum;
    }

    public String getTriggertype() {
        return triggertype;
    }

    public void setTriggertype(String triggertype) {
        this.triggertype = triggertype;
    }
}

