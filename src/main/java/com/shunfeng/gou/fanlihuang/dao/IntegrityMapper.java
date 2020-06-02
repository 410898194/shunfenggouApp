package com.shunfeng.gou.fanlihuang.dao;

import com.shunfeng.gou.fanlihuang.entity.Integrity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface IntegrityMapper extends MyMapper<Integrity> {

    @Select("SELECT changetime,orderid,triggertype,changenum FROM `integrity` WHERE userid = #{userid}")
    List<Integrity> selectIntegrity(String userid);

    /**
     * 总诚信值
     * @param userid
     * @return
     */
    @Select("SELECT changenum from `integrity` where userid = #{userid}")
    List<Integer> getallintegrity(String userid);

    @Update("update `user` set userlimit = -1")
    void setuserlimitdown(String userid);

    /**
     * 完成订单诚信值变更
     * @param userid
     * @param orderid
     */
    @Insert("insert into `integrity`(userid,orderid) values (#{userid},#{orderid})")
    void insertintegrity(String userid,int orderid);
    @Update("update `integrity` set changenum = 5,triggertype = '完成订单',changetime = #{changetime} where #{orderid}")
    void finishordersetintegrityup(int orderid, Date changetime);
    @Update("update `integrity` set changenum = -20,triggertype = '订单超时',changetime = #{changetime} where #{orderid}")
    void finishordersetintegritydown(int orderid,Date changetime);



}