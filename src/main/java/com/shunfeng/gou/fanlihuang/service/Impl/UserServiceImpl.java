package com.shunfeng.gou.fanlihuang.service.Impl;

import com.shunfeng.gou.fanlihuang.dao.UserMapper;
import com.shunfeng.gou.fanlihuang.entity.User;
import com.shunfeng.gou.fanlihuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Author:Administrator
 * @Date:2020/4/2216:46
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertuserinfo(String username, String usertelephone, String useremail,String openid) {
        userMapper.insertuserinfo(username,usertelephone,useremail,openid);
    }

//    @Override
//    public void insertopenid(String openid) {
//        userMapper.insertopenid(openid);
//    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public String getuserlimit(String openid) {
        String userstatus = userMapper.getuserlimit(openid);
        return userstatus;
    }

    @Override
    public void insertwechat(String id,String wechatname,String userlimit,int integrity,int remaindercanceltimes) {
        userMapper.insertwechat(id,wechatname,userlimit,integrity,remaindercanceltimes);
    }

    @Override
    public String judgeopenid(String id) {
        return userMapper.judgeopenid(id);
    }

    @Override
    public void setuserlimitone() {
        userMapper.setuserlimitone();
    }


}
