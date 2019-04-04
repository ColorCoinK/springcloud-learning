package com.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.learning.entity.PushConifg;
import com.learning.entity.PushVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XgPushApplicationTests {

	@Autowired
	private RestTemplate template;

	@Test
	public void testXGPush() {
		PushVO pushVO = template.getForObject("http://127.0.0.1:9099/push/centerSheet/125",
				PushVO.class);
		System.out.println(pushVO.toString());
	}

	@Test
	public void testJsonObject2String() {
	}
}
