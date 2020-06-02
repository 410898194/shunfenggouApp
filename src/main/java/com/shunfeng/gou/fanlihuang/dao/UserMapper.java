package com.shunfeng.gou.fanlihuang.dao;

import com.shunfeng.gou.fanlihuang.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

@Repository
public interface UserMapper extends MyMapper<User> {

    @Update("update `user` set username = #{username},usertelephone = #{telephone},useremail = #{useremail} where id = #{openid}")
    void insertuserinfo(String username,String telephone,String useremail,String openid);

//    @Insert("INSERT INTO `user`(id) VALUE (#{openid})")
//    void insertopenid(String openid);

    @Update("update `user` set userlimit = 1")
    void setuserlimitone();

    @Select("select id from `user` where id = #{id}")
    String judgeopenid(String id);

    @Select("SELECT userlimit from `user` where id = #{openid}")
    String getuserlimit(String openid);

    @Insert("INSERT INTO `user`(id,wechatname,userlimit,integrity,remaindercanceltimes) VALUES (#{id},#{wechatname},#{userlimit},#{integrity},#{remaindercanceltimes})")
    void insertwechat(String id,String wechatname,String userlimit,int integrity,int remaindercanceltimes);
}