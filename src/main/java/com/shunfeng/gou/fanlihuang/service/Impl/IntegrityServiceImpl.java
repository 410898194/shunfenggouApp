package com.shunfeng.gou.fanlihuang.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.dao.IntegrityMapper;
import com.shunfeng.gou.fanlihuang.entity.Integrity;
import com.shunfeng.gou.fanlihuang.service.IntegrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName:IntegrityServiceImpl
 * @Author:Administrator
 * @Date:2020/4/2716:25
 * @Version 1.0
 */

@Service
public class IntegrityServiceImpl implements IntegrityService {

    @Autowired
    private IntegrityMapper integrityMapper;


    /**
     * 根据openid查询诚信值
     * @param userid
     * @return
     */
    @Override
    public List<Integrity> selectIntegrity(String userid) {

        List<Integrity> integrity = integrityMapper.selectIntegrity(userid);
        if (integrity.isEmpty())
        {
            return null;
        }
        return integrity;

    }

    /**
     * 管理员查看所有诚信值记录
     * @return
     */
    @Override
    public List<Integrity> selectallintegrity() {
        return integrityMapper.selectAll();
    }

    @Override
    public List<Integer> getallintegrity(String userid) {
        return integrityMapper.getallintegrity(userid);
    }

    /**
     * 检查诚信值，若为零则置userilimit为-1
     * @param userid
     */
    @Override
    public void setuserlimitdown(String userid) {
        integrityMapper.setuserlimitdown(userid);
    }

    @Override
    public void insertintegrity(String userid, int orderid) {
        integrityMapper.insertintegrity(userid,orderid);
    }


    @Override
    public void finishordersetintegrityup(int orderid, Date changetime) {
        integrityMapper.finishordersetintegrityup(orderid,changetime);
    }

    @Override
    public void finishordersetintegritydown(int orderid, Date changetime) {
        integrityMapper.finishordersetintegritydown(orderid,changetime);
    }


}
