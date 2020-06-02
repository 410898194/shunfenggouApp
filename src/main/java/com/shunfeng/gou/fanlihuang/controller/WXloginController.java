package com.shunfeng.gou.fanlihuang.controller;






import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.kevinsawicki.http.HttpRequest;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:WXloginController
 * @Author:Fanlihuang
 * @Date:2020/4/9 16:42
 * @Version 1.0
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class WXloginController {

    private static final Logger logger= LoggerFactory.getLogger(WXloginController.class);

    @Autowired
    UserService userService;

    private String appID = "wx4142a4a34de10776";
    private String appSecret = "8f3c719816c7d5d4d04a4c4b6715416f";




    @GetMapping("/getOpenid")
    public String  userLogin(@RequestParam(value = "code")String code,String wechatname) throws IOException {




        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", this.appID);
        data.put("secret", this.appSecret);
        data.put("js_code", code);
        data.put("grant_type", "client_credential");


        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(data).body();
        System.out.println("Response was: " + response);
        JSONObject obj= JSON.parseObject(response);//将json字符串转换为json对
        System.out.println(obj);
        System.out.println(userService.judgeopenid(obj.getString("openid")));
        if((userService.judgeopenid(obj.getString("openid")))==null)
        {
//            userService.insertopenid(obj.getString("openid"));
            String userlimit = "2";
            int integrity = 80;
            int remaindercanceltimes = 3;
            userService.insertwechat(obj.getString("openid"),wechatname,userlimit,integrity,remaindercanceltimes);
        }

        return obj.getString("openid");



    }
}
