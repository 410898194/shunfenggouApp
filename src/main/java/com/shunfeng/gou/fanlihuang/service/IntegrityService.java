package com.shunfeng.gou.fanlihuang.service;

import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.entity.Integrity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface IntegrityService {

    /**
     * 查询诚信值
     * @param userid
     * @return
     */
    List<Integrity> selectIntegrity(String userid);

    List<Integrity> selectallintegrity();

    /**
     * 总诚信值
     * @param userid
     * @return
     */
    List<Integer> getallintegrity(String userid);

    /**
     * 若诚信值为0，userlimit置为-1
     * @param userid
     */
    void setuserlimitdown(String userid);

    /**
     * 新增诚信记录
     * @param userid
     * @param orderid
     */
    void insertintegrity(String userid,int orderid);

    /**
     * 订单结束时诚信值变更
     * @param orderid
     */
    void finishordersetintegrityup(int orderid, Date changetime);
    void finishordersetintegritydown(int orderid, Date changetime);


}
