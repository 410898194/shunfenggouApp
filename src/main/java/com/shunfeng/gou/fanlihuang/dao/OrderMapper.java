package com.shunfeng.gou.fanlihuang.dao;

import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.entity.Order;
import com.shunfeng.gou.fanlihuang.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;


@Repository
public interface OrderMapper extends MyMapper<Order> { //tk mapper  mybatisplus

    @Select("select orderinfo from `order` where orderid = #{orderid}")
    String selectorderinfobyorderid(int orderid);

    @Select("select * FROM `order` WHERE orderstatus = 0")
    List<Order> selectorderinfo();


    /**
     * 下订单
     * @param openid
     * @param useraddress
     * @param username
     * @param usertelephone
     * @param serviceid
     * @param image
     * @param ordertime
     * @param orderstatus
     * @param usercheck
     * @param drivercheck
     * @param orderinfo
     * @param rewardamount
     * @param goldaddress
     * @param urgent
     */
    @Insert("INSERT INTO `order` (openid,useraddress,username,usertelephone,serviceid,image,ordertime,orderstatus,usercheck,drivercheck,orderinfo,rewardamount,goldaddress,urgent,wechatname,wechathead) VALUES(#{openid},#{useraddress},#{username},#{usertelephone},#{serviceid},#{image},#{ordertime},#{orderstatus},#{usercheck},#{drivercheck},#{orderinfo},#{rewardamount},#{goldaddress},#{urgent},#{wechatname},#{wechathead})")
    void createorder(String openid,String useraddress,String username,String usertelephone,int serviceid,String image,Date ordertime,String orderstatus,String usercheck,String drivercheck,String orderinfo,int rewardamount,String goldaddress,String urgent,String wechatname,String wechathead);

    /**
     * 骑手确认
     */
    @Update("update `order` set drivercheck = 1,arrivetime = #{arrivetime} where orderid =#{orderid}")
    void DriverCheck(int orderid,Date arrivetime);

    /**
     * 顾客确认
     */
    @Update("update `order` set usercheck = 1 where orderid = #{orederid}")
    void UserCheck(int orderid);

    @Select("select usercheck from `order` where orderid = #{orderid}")
    String selectusercheck(int orderid);
    @Select("select drivercheck from `order` where orderid = #{orderid}")
    String selectdrivercheck(int orderid);


    /**
     * 顾客骑手都确认之后将订单状态置为2（已完成）
     * @param orderid
     * @return
     */
    @Update("update `order` set orderstatus = 2 where orderid = #{orderid}")
    void finishorder(int orderid);

    /**
     * 查看自己所有已发布订单
     * @param openid
     * @return
     */
    @Select("select * from `order` where openid = #{openid}")
    List<Order> selectownorder(String openid);

    /**
     * 接单
     * @param username
     * @param usertelephone
     * @param orderid
     */
    @Update("update `order` set driveropenid = #{openid},drivername = #{username},drivertelephone = #{usertelephone},accepttime = #{accepttime} where orderid = #{orderid}")
    void driveracceptorder(String openid,String username,String usertelephone,int orderid,Date accepttime);
    @Update("UPDATE `order` SET orderstatus = 1 where orderid = #{orderid}")
    void changeorderstatus(int orderid);



    /**
     * 查看已接订单
     * @param openid
     * @return
     */
    @Select("select * from `order` where driveropenid = #{openid}")
    List<Order> selectownacceptorder(String openid);



    /**
     * 根据openid查用户名和用户手机
     * @param openid
     * @return
     */
    @Select("SELECT username,usertelephone from `user` where id = #{openid}")
    User GetUserInfo(String openid);

    /**
     * 用户取消订单
     * @param orderid
     */
    @Delete("delete from `order` where orderid = #{orderid}")
    void usercancelorder(int orderid);
    @Select("select orderstatus from `order` where orderid = #{orderid}")
    String selectorderstatus(int orderid);

    /**
     * 骑手取消订单
     * @param orderid
     */
    @Update("update `order` set orderstatus = 0 where orderid = #{orderid}")
    void drivercancelorder(int orderid);
    @Update("update `user` set remaindercanceltimes = remaindercanceltimes - 1 where id =#{openid}")
    void setremaindercanceltimesdown(String openid);

    @Update("update `user` set remaindercanceltimes = 3")
    void setremaindercanceltimesthree();

    @Select("select accepttime,openid,orderid,urgent from `order`")
    List<JSONObject> checkordertime();

}