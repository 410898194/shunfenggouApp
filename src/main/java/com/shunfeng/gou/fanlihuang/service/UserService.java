package com.shunfeng.gou.fanlihuang.service;

import com.shunfeng.gou.fanlihuang.entity.User;

import java.util.List;


public interface UserService {

    void insertuserinfo(String username,String usertelephone,String useremail,String openid);
//    void insertopenid(String openid);
    List<User> selectAllUser();
    String getuserlimit(String openid);
    void insertwechat(String id,String wechatname,String userlimit,int integrity,int remaindercanceltimes);
    String judgeopenid(String id);
    void setuserlimitone();

}
