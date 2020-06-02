package com.shunfeng.gou.fanlihuang.entity;

import javax.persistence.*;

@Table(name = "shunfenggou.server")
public class Server {
    @Id
    private Integer serviceid;

    private String servicename;

    private String image;

    /**
     * @return serviceid
     */
    public Integer getServiceid() {
        return serviceid;
    }

    /**
     * @param serviceid
     */
    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    /**
     * @return servicename
     */
    public String getServicename() {
        return servicename;
    }

    /**
     * @param servicename
     */
    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }
}