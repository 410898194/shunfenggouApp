package com.shunfeng.gou.fanlihuang.service.Impl;

import com.shunfeng.gou.fanlihuang.dao.FeedbackMapper;
import com.shunfeng.gou.fanlihuang.entity.Feedback;
import com.shunfeng.gou.fanlihuang.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName:FeedBackServiceImpl
 * @Author:Administrator
 * @Date:2020/4/2316:16
 * @Version 1.0
 */
@Service
public class FeedBackServiceImpl implements FeedBackService{

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public void CreateFeedBack(String feedbackname,String feedbackinfo, String contactinfo,Date feedbacktime) {
            feedbackMapper.CreateFeedBack(feedbackname,feedbackinfo,contactinfo,feedbacktime);
    }

    @Override
    public List<Feedback> selectAll() {
        return feedbackMapper.selectAll();

    }
}
