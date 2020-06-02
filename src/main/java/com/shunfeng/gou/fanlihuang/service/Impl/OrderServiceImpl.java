package com.shunfeng.gou.fanlihuang.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.dao.OrderMapper;
import com.shunfeng.gou.fanlihuang.entity.Order;
import com.shunfeng.gou.fanlihuang.entity.User;
import com.shunfeng.gou.fanlihuang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName:OrderServiceImpl
 * @Author:Administrator
 * @Date:2020/4/1421:03
 * @Version 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectorderinfo() {
        return orderMapper.selectorderinfo();
    }

    /**
     * 接单
     */
    @Override
    public void changeorderstatus(int orderid) {
        orderMapper.changeorderstatus(orderid);
    }
    @Override
    public void driveracceptorder(String openid,String username, String usertelephone,int orderid,Date accepttime) {
        orderMapper.driveracceptorder(openid,username,usertelephone,orderid,accepttime);
    }

    @Override
    public User GetUserInfo(String openid) {
        return orderMapper.GetUserInfo(openid);
    }


    /**
     * 查看自己已接订单
     * @param openid
     * @return
     */
    @Override
    public List<Order> selectownacceptorder(String openid) {
        return orderMapper.selectownacceptorder(openid);
    }

    @Override
    public void finishorder(int orderid) {
        orderMapper.finishorder(orderid);
    }

    /**
     * 搜索骑手用户确认标志
     * @param orderid
     * @return
     */
    @Override
    public String selectusercheck(int orderid) {
        return orderMapper.selectusercheck(orderid);
    }
    @Override
    public String selectdrivercheck(int orderid) {
        return orderMapper.selectdrivercheck(orderid);
    }

    /**
     * 用户取消订单
     * @param orderid
     */
    @Override
    public void usercancelorder(int orderid) {
        orderMapper.usercancelorder(orderid);
    }

    /**
     * 查询订单状态
     * @param orderid
     * @return
     */
    @Override
    public String selectorderstatus(int orderid) {
        return orderMapper.selectorderstatus(orderid);
    }

    @Override
    public void drivercancelorder(int orderid) {
        orderMapper.drivercancelorder(orderid);
    }

    @Override
    public void setremaindercanceltimesdown(String openid) {
        orderMapper.setremaindercanceltimesdown(openid);
    }

    @Override
    public void setremaindercanceltimesthree() {
        orderMapper.setremaindercanceltimesthree();
    }

    @Override
    public void createorder(String openid,String useraddress, String username, String usertelephone,int serviceid, String image, Date ordertime, String orderstatus, String usercheck, String drivercheck, String orderinfo, int rewardamount, String goldaddress, String urgent,String wechatname,String wechathead) {
        ordertime = new Date();
        orderMapper.createorder(openid,useraddress,username,image,serviceid,usertelephone,ordertime,orderstatus,usercheck,drivercheck,orderinfo,rewardamount,goldaddress,urgent,wechatname,wechathead);
    }



    /**
     * 骑手确认
     */
    @Override
    public void DriverCheck(int orderid,Date arrivetime) {
        orderMapper.DriverCheck(orderid,arrivetime);
    }

    /**
     * 顾客确认
     */
    @Override
    public void UserCheck(int orderid) {
        orderMapper.UserCheck(orderid);
    }

    /**
     * 查看自己所有已发布订单
     * @param openid
     * @return
     */
    @Override
    public List<Order> selectownorder(String openid) {
        return orderMapper.selectownorder(openid);
    }


    @Override
    public List<JSONObject> checkordertime() {
        return orderMapper.checkordertime();
    }

    @Override
    public String selectorderinfobyorderid(int orderid) {
        return orderMapper.selectorderinfobyorderid(orderid);
    }


}
