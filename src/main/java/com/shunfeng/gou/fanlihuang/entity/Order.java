package com.shunfeng.gou.fanlihuang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {
    /**
     *
     */
    private Integer orderid;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String usertelephone;

    /**
     *
     */
    private String goldaddress;

    /**
     *
     */
    private String useraddress;

    /**
     *
     */
    private String urgent;

    /**
     *
     */
    private String orderinfo;

    /**
     *
     */
    private Integer rewardamount;

    /**
     *
     */
    private String drivername;

    /**
     *
     */
    private String drivertelephone;

    /**
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ordertime;

    /**
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivetime;

    /**
     *
     */
    private String orderstatus;

    /**
     *
     */
    private Integer serviceid;

    /**
     *
     */
    private String image;

    /**
     *
     */
    private String usercheck;

    /**
     *
     */
    private String drivercheck;

    /**
     *
     */
    private String openid;

    /**
     *
     */
    private String wechatname;

    /**
     *
     */
    private String wechathead;

    /**
     *
     */
    private String driveropenid;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertelephone() {
        return usertelephone;
    }

    public void setUsertelephone(String usertelephone) {
        this.usertelephone = usertelephone;
    }

    public String getGoldaddress() {
        return goldaddress;
    }

    public void setGoldaddress(String goldaddress) {
        this.goldaddress = goldaddress;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(String orderinfo) {
        this.orderinfo = orderinfo;
    }

    public Integer getRewardamount() {
        return rewardamount;
    }

    public void setRewardamount(Integer rewardamount) {
        this.rewardamount = rewardamount;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDrivertelephone() {
        return drivertelephone;
    }

    public void setDrivertelephone(String drivertelephone) {
        this.drivertelephone = drivertelephone;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsercheck() {
        return usercheck;
    }

    public void setUsercheck(String usercheck) {
        this.usercheck = usercheck;
    }

    public String getDrivercheck() {
        return drivercheck;
    }

    public void setDrivercheck(String drivercheck) {
        this.drivercheck = drivercheck;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWechatname() {
        return wechatname;
    }

    public void setWechatname(String wechatname) {
        this.wechatname = wechatname;
    }

    public String getWechathead() {
        return wechathead;
    }

    public void setWechathead(String wechathead) {
        this.wechathead = wechathead;
    }

    public String getDriveropenid() {
        return driveropenid;
    }

    public void setDriveropenid(String driveropenid) {
        this.driveropenid = driveropenid;
    }
}

