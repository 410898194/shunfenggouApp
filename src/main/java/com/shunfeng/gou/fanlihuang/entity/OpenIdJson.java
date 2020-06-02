package com.shunfeng.gou.fanlihuang.entity;

import javax.persistence.Entity;

/**
 * @ClassName:OpenIdJson
 * @Author:Administrator
 * @Date:2020/4/2316:39
 * @Version 1.0
 */

@Entity
public class OpenIdJson {
    private String openid;
    private String session_key;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}