package com.shunfeng.gou.fanlihuang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "shunfenggou.set")
public class Set {
    @Id
    private String settingman;

    private Integer settimes;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date settime;

    /**
     * @return settingman
     */
    public String getSettingman() {
        return settingman;
    }

    /**
     * @param settingman
     */
    public void setSettingman(String settingman) {
        this.settingman = settingman;
    }

    /**
     * @return settimes
     */
    public Integer getSettimes() {
        return settimes;
    }

    /**
     * @param settimes
     */
    public void setSettimes(Integer settimes) {
        this.settimes = settimes;
    }

    /**
     * @return settime
     */
    public Date getSettime() {
        return settime;
    }

    /**
     * @param settime
     */
    public void setSettime(Date settime) {
        this.settime = settime;
    }
}