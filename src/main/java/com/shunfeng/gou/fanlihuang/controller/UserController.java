package com.shunfeng.gou.fanlihuang.controller;


import com.shunfeng.gou.fanlihuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:UserController
 * @Author:Administrator
 * @Date:2020/2/2418:37
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/User")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;



    /**
     * 个人信息认证
     * @param username
     * @param usertelephone
     * @param useremail
     */
    @PostMapping("/insertUserInfo")
    public void InsertUserInfo(String username,String usertelephone,String useremail,String openid)
    {

        userService.insertuserinfo(username,usertelephone,useremail,openid);
        userService.setuserlimitone();
    }

    @GetMapping("/getUserLimit")
    public String GetUserLimit(String openid){
        return userService.getuserlimit(openid);
    }



}
