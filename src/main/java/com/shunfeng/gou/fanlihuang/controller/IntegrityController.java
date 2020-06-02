package com.shunfeng.gou.fanlihuang.controller;


import com.shunfeng.gou.fanlihuang.entity.Integrity;
import com.shunfeng.gou.fanlihuang.service.IntegrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName:IntegrityController
 * @Author:Fanlihuang
 * @Date:2020/4/27 16:24
 * @Version 1.0
 */

@RestController
@RequestMapping("/Integrity")
@CrossOrigin(origins = "*",maxAge = 3600)
public class IntegrityController {

    @Autowired
    IntegrityService integrityService;

    /**
     * 查询自己诚信值记录，若没有记录返回null
     * @param userid
     * @return
     */
    @GetMapping("/getIntegrity")
    public List<Integrity> GetIntegrity(String userid)
    {
        return integrityService.selectIntegrity(userid);
    }

    /**
     * 总诚信值
     * @param userid
     * @return
     */
    @GetMapping("/getAllIntegrity")
    public Integer GetAllIntegrity(String userid)
    {
        List<Integer> allintegrity = integrityService.getallintegrity(userid);
        Integer sum = 80;
        for (int i = 0; i < allintegrity.size() ; i++) {
            sum += allintegrity.get(i);
            if(sum >= 100)
            {
                return 100;
            }
        }
        if(sum <= 0)
        {
            integrityService.setuserlimitdown(userid);//若诚信值小于等于0则将userlimit置为-1
            return 0;
        }
        return sum;
    }



}
