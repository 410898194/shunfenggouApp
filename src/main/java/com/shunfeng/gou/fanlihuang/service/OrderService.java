package com.shunfeng.gou.fanlihuang.service;

import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.entity.Order;
import com.shunfeng.gou.fanlihuang.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface OrderService {

    List<Order> selectorderinfo();

    void changeorderstatus(int orderid);

    void createorder(String openid, String useraddress, String username, String usertelephone, int serviceid, String image, Date ordertime, String orderstatus, String usercheck, String drivercheck, String orderinfo, int rewardamount, String goldaddress, String urgent, String wechatname, String wechathead);

    void DriverCheck(int orderid,Date arrivetime);

    void UserCheck(int orderid);

    List<Order> selectownorder(String openid);

    void driveracceptorder(String openid, String username, String usertelephone, int orderid,Date accepttime);

    User GetUserInfo(String openid);

    List<Order> selectownacceptorder(String openid);

    void finishorder(int orderid);

    String selectusercheck(int orderid);

    String selectdrivercheck(int orderid);

    void usercancelorder(int orderid);

    String selectorderstatus(int orderid);

    void drivercancelorder(int orderid);

    void setremaindercanceltimesdown(String openid);

    void setremaindercanceltimesthree();

    List<JSONObject> checkordertime();

    String selectorderinfobyorderid(int orderid);
}
