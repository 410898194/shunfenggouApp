package com.shunfeng.gou.fanlihuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.shunfeng.gou.fanlihuang.entity.SingleSubscribeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MessageController {

    private RestTemplate restTemplate;



    public  void send(String openid,String status,int orderid,String orderinfo){



        Map<String, String> post = new HashMap<>();
        post.put("grant_type","client_credential");
        post.put("appID","wx4142a4a34de10776");
        post.put("appSecert","8f3c719816c7d5d4d04a4c4b6715416f");

        String response = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/token").form(post).body();
        JSONObject jsonObject = JSON.parseObject(response);
        String accesstoken = jsonObject.getString("access_token");

        Date date = new Date();
        String s = JSON.toJSONStringWithDateFormat(date, "yyyy-mm-dd");

        Map<String, String> data = new HashMap<>();
        data.put("status",status);
        data.put("orderid",orderid + "");
        data.put("date",s);
        data.put("orderinfo",orderinfo);

        SingleSubscribeMessage message =new SingleSubscribeMessage();
        message.setAccesstoken(accesstoken);
        message.setTouser(openid);
        message.setTemplate_id("702");
        message.setData(data);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://api.weixin.qq.com/cgi-bin/message/subscribe/send", message, String.class);
        String s1 = responseEntity.getBody();
        JSONObject json = JSONObject.parseObject(s1);
        long errcode = json.getLong("errcode");

    }


}
