package com.shunfeng.gou.fanlihuang.dao;

import com.shunfeng.gou.fanlihuang.entity.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;
import java.util.List;


public interface FeedbackMapper extends MyMapper<Feedback> {

    @Insert("INSERT INTO feedback(feedbackname,feedbackinfo,contactinfo,feedbacktime) VALUES (#{feedbackname},#{feedbackinfo},#{contactinfo},#{feedbacktime})")
    void CreateFeedBack(@Param("feedbackname") String feedbackname,@Param("feedbackinfo") String feedbackinfo,@Param("contactinfo") String contactinfo,@Param("feedbacktime") Date feedbacktime);
//    @Select("SELECT id,feedbackname,feedbackinfo,contactinfo,feedbacktime FROM `feedback`")
//    List<Feedback> selectAllfeedback();
}