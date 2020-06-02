package com.shunfeng.gou.fanlihuang.controller;

import com.shunfeng.gou.fanlihuang.entity.Feedback;
import com.shunfeng.gou.fanlihuang.entity.Integrity;
import com.shunfeng.gou.fanlihuang.entity.User;
import com.shunfeng.gou.fanlihuang.service.FeedBackService;
import com.shunfeng.gou.fanlihuang.service.IntegrityService;
import com.shunfeng.gou.fanlihuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:RootController
 * @Author:Administrator
 * @Date:2020/4/2816:44
 * @Version 1.0
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private IntegrityService integrityService;

    @Autowired
    private FeedBackService feedBackService;

    /*
     * 管理员查找所有用户
     * @return
     */
    @GetMapping("/rootselectAllUser")
    public List<User> SelectAllUser()
    {
        return userService.selectAllUser();
    }

    /**
     * 管理员查看诚信值
     * @return
     */
    @GetMapping("/rootselectAllIntegrity")
    public List<Integrity> SelectAllIntegrity()
    {
        return integrityService.selectallintegrity();
    }

    /**
     * 管理员查询所有反馈信息
     */
    @GetMapping("/rootgetFeedback")
    public List<Feedback> GetFeedBack(){

        List<Feedback> feedbacks = feedBackService.selectAll();
        return feedbacks;

    }
}
