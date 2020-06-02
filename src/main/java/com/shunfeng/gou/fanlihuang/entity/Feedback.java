package com.shunfeng.gou.fanlihuang.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Feedback {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     */
    private String feedbackname;

    /**
     *
     */
    private String feedbackinfo;

    /**
     *
     */
    private String contactinfo;

    /**
     *
     */

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date feedbacktime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedbackname() {
        return feedbackname;
    }

    public void setFeedbackname(String feedbackname) {
        this.feedbackname = feedbackname;
    }

    public String getFeedbackinfo() {
        return feedbackinfo;
    }

    public void setFeedbackinfo(String feedbackinfo) {
        this.feedbackinfo = feedbackinfo;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    public Date getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(Date feedbacktime) {
        this.feedbacktime = feedbacktime;
    }
}

