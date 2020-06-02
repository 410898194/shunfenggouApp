package com.shunfeng.gou.fanlihuang.service.Impl;

import com.shunfeng.gou.fanlihuang.dao.ServerMapper;
import com.shunfeng.gou.fanlihuang.entity.Server;
import com.shunfeng.gou.fanlihuang.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerMapper serverMapper;


}
