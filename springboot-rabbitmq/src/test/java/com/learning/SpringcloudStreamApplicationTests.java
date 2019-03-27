package com.learning;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudStreamApplicationTests {


	@Test
	public void contextTest() {
		System.out.println(new Date());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}


}
