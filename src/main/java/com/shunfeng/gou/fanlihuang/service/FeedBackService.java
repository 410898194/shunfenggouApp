package com.shunfeng.gou.fanlihuang.service;

import com.shunfeng.gou.fanlihuang.entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface FeedBackService {

    void CreateFeedBack(String feedbackname,String feedbackinfo, String contactinfo,Date feedbacktime);
    List<Feedback> selectAll();

}
