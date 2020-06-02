package com.shunfeng.gou.fanlihuang.config;

import com.shunfeng.gou.fanlihuang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduTask {

    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "0 0 0 * * ?")
    private void testSca(){
//        System.out.println(111)
        orderService.setremaindercanceltimesthree();
    }
}
