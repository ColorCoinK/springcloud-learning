package com.example.xgpush;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.service.XgPushService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseXgTest {

	@Autowired
	private XgPushService xgPushService;

	@Test
	public void PushSingleAndroidTest() {

	}

}
