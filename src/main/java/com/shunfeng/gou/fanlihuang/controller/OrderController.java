package com.shunfeng.gou.fanlihuang.controller;



import com.shunfeng.gou.fanlihuang.entity.Order;
import com.shunfeng.gou.fanlihuang.entity.User;
import com.shunfeng.gou.fanlihuang.service.IntegrityService;
import com.shunfeng.gou.fanlihuang.service.OrderService;
import com.shunfeng.gou.fanlihuang.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName:OrderController
 * @Author:Administrator
 * @Date:2020/3/1418:04
 * @Version 1.0
 */

@RequestMapping(value = "/Order")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {



    @Autowired
    OrderService orderService;
    @Autowired
    ServerService serverService;
    @Autowired
    IntegrityService integrityService;
    @Autowired
    MessageController messageController;

    /**
     * 显示订单信息
     * @return
     */
    @GetMapping("/getOrderInfo")
    public List<Order> GetOrderInfo(){

        return orderService.selectorderinfo();

    }

    /**
     * 接单
     */
    @PostMapping("/changeOrderStatus")
    public void ChangeOrderStatus(String openid,int orderid)
    {

        messageController.send(openid,"已被接单",orderid,orderService.selectorderinfobyorderid(orderid));
        orderService.changeorderstatus(orderid);
        User user = orderService.GetUserInfo(openid);
        String username = user.getUsername();
        String usertelephone = user.getUsertelephone();
        Date accepttime = new Date();
        orderService.driveracceptorder(openid,username,usertelephone,orderid,accepttime);
    }

    /**
     * 下订单
     * @param openid
     * @param wechatname
     * @param wechathead
     * @param useraddress
     * @param username
     * @param usertelephone
     * @param serviceid
     * @param image
     * @param orderinfo
     * @param rewardamount
     * @param goldaddress
     * @param urgent
     */
    @PostMapping("/createOrder")
    public void CreateOrder(String openid,String wechatname,String wechathead,String useraddress,String username,String usertelephone, int serviceid,String image,String orderinfo, int rewardamount, String goldaddress, String urgent){
        String usercheck = "0";
        String drivercheck = "0";
        Date ordertime = new Date();
        String orderstatus = "0";
        orderService.createorder(openid,useraddress,username,image,serviceid,usertelephone,ordertime,orderstatus,usercheck,drivercheck,orderinfo,rewardamount,goldaddress,urgent,wechatname,wechathead);
    }

    /**
     * 骑手确认
     */
    @PostMapping("/driverCheck")
    public void DriverCheck(String openid,int orderid)
    {
        messageController.send(openid,"订单确认送达",orderid,orderService.selectorderinfobyorderid(orderid));
        Date arrivetime = new Date();
        orderService.DriverCheck(orderid,arrivetime);
        integrityService.insertintegrity(openid,orderid);
        if(orderService.selectusercheck(orderid).equals("1"))
        {
            orderService.finishorder(orderid);
            Date changetime = new Date();
            integrityService.finishordersetintegrityup(orderid,changetime);
        }
    }

    /**
     * 顾客确认
     */
    @PostMapping("/userCheck")
    public void UserCheck(String openid,int orderid)
    {
        messageController.send(openid,"您已确认订单送达",orderid,orderService.selectorderinfobyorderid(orderid));
        orderService.UserCheck(orderid);
//        integrityService.insertintegrity(openid,orderid);
        if(orderService.selectdrivercheck(orderid).equals("1"))
        {
            orderService.finishorder(orderid);

            Date changetime = new Date();
            integrityService.finishordersetintegrityup(orderid,changetime);
        }
    }

    /**
     * 查看自己所有已发布订单
     * @param openid
     * @return
     */
    @GetMapping("/selectOwnOrder")
    public List<Order> selectownorder(String openid)
    {
        return orderService.selectownorder(openid);
    }


    /**
     * 查看自己所有已接订单
     * @param openid
     * @return
     */
    @GetMapping("/selectOwnAcceptOrder")
    public List<Order> selectownacceptorder(String openid)
    {
        return orderService.selectownacceptorder(openid);
    }

    /**
     * 用户取消订单
     * @param orderid
     */
    @DeleteMapping("/usercancelorder")
    public void cancelorder(int orderid)
    {

        if(orderService.selectorderstatus(orderid).equals("0"))
        {
            orderService.usercancelorder(orderid);
        }

    }

    /**
     * 骑手取消订单
     * @param openid
     * @param orderid
     */
    @GetMapping("/drivercancelorder")
    public void drivercancelorder(String openid,int orderid)
    {
        messageController.send(openid,"骑手已取消您的订单",orderid,orderService.selectorderinfobyorderid(orderid));
        orderService.drivercancelorder(orderid);
        orderService.setremaindercanceltimesdown(openid);
    }

}