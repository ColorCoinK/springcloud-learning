package com.learning.utils;

import com.learning.enumerate.ParseToken;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUtilTest {


	@Test
	public void jwsTest() {
		//1001,'admin',18,'男','1','ROLE_ADMIN'
		System.out.println(JwtUtil.createJws(1001L, "admin", "admin", 1000 * 60 * 10));
	}

	@Test
	public void analysisTokenTest(){
		Object result = JwtUtil.analysisToken("eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEwMDEsInVzZXJfbmFtZSI6ImFkbWluIiwiZXhwIjoxNTU0MzU2MDQ5LCJpYXQiOjE1NTQzNTU0NDl9.mP6ahc5ra5rtNOMY5T1FyfdslNJ_gN0PZtKvyLB7Bso",
				ParseToken.USER_NAME);
		System.out.println(result);

	}

	@Test
	public void parseJWsTest() {
		Claims claims = new JwtUtil().parseJWs(
				"eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEwMDEsInBhc3N3b3JkIjoiYWRtaW4iLCJ1c2VyX25hbWUiOiJhZG1pbiIsImV4cCI6MTU1MDgyMDcwOSwiaWF0IjoxNTUwODIwMTA5fQ.sh0ppz6cDOlK0ewlC0-cCFkyOV_FsVfvCTR4JzrmRTI");
		System.out.println(claims);
	}
}