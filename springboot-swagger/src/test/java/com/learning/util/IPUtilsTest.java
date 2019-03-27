package com.learning.util;

import java.net.InetAddress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPUtilsTest {

	@Test
	public void getIPTest() {
		InetAddress address = IPUtils.getLocalHostLANAddress();
		System.out.println(address.toString());

	}
}
