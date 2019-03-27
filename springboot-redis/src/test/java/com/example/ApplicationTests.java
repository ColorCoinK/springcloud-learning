package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() {
		stringRedisTemplate.opsForValue().set("Alibaba", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("Alibaba"));
	}

	@Test
	public void objextTest() {
		User user = new User("荣耀", 20);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new User("中兴", 10);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new User("小米", 15);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("荣耀").getAge().longValue());
		Assert.assertEquals(10, redisTemplate.opsForValue().get("中兴").getAge().longValue());
		Assert.assertEquals(15, redisTemplate.opsForValue().get("小米").getAge().longValue());

	}

}
