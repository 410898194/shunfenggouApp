package com.shunfeng.gou.fanlihuang.controller;

import com.shunfeng.gou.fanlihuang.entity.Feedback;
import com.shunfeng.gou.fanlihuang.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

/**
 * @ClassName:FeedBackController
 * @Author:Administrator
 * @Date:2020/4/2316:13
 * @Version 1.0
 */

@RestController
@RequestMapping("/Feedback")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FeedBackController {

    @Autowired
    FeedBackService feedBackService;

    /**
     * 意见反馈
     * @param feedbackinfo
     * @param contactinfo
     */
    @PostMapping("/createFeedback")
    public void CreateFeedBack(String feedbackname,String feedbackinfo, String contactinfo){

        Date feedbacktime = new Date();
        feedBackService.CreateFeedBack(feedbackname,feedbackinfo,contactinfo,feedbacktime);

    }






}
