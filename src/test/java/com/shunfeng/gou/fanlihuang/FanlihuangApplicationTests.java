package com.shunfeng.gou.fanlihuang;

import com.shunfeng.gou.fanlihuang.service.FeedBackService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class FanlihuangApplicationTests {

	@Autowired
	FeedBackService feedBackService;

	@Test
	void contextLoads() {
	}



}
