package com.shunfeng.gou.fanlihuang.config;


import com.alibaba.fastjson.JSONObject;
import com.shunfeng.gou.fanlihuang.service.IntegrityService;
import com.shunfeng.gou.fanlihuang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AutoCancelOrder {

    @Autowired
    OrderService orderService;
    @Autowired
    IntegrityService integrityService;

    @Scheduled(cron = "0 0 */1 * * *")
    public void checkordertime()
    {
        Date date = new Date();
        List<JSONObject> checktime = orderService.checkordertime();

        for (int i = 0; i < checktime.size(); i++) {
            int orderid = checktime.get(i).getInteger("orderid");
            Date accepttime= checktime.get(i).getDate("accepttime");
            if (checktime.get(i).getString("urgent").equals('1'))
            {
                if (  date.getTime() - accepttime.getTime()>= 7200000)
                {
                    integrityService.finishordersetintegritydown(orderid,date);
                }
            }else if(  date.getTime() - accepttime.getTime()>= 86400000 && orderService.selectdrivercheck(checktime.get(i).getInteger("orderid")).equals('1'))
            {
                orderService.UserCheck(orderid);
                integrityService.finishordersetintegritydown(orderid,date);
            }
        }
    }

}
