package com.learning.repository;

import com.learning.entity.UserPO;
import com.learning.entity.dto.UserDto;
import com.learning.enumerate.ParseToken;
import com.learning.utils.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;


	@Test
	public void findByNameAndPasswordTest() {
		UserPO userInfo = this.userRepository.findByNameAndPassword("admin", "1");
		Long exp = new UserDto().getExpritaion();
		// 创建token
		String token = JwtUtil.createJws(userInfo.getId(), userInfo.getName(),
				userInfo.getPassword(),
				exp);

		// 只获取uid
		Long uid = (Long) JwtUtil.analysisToken(token, ParseToken.UID);
		System.err.println("Token u_id:\t" + uid);
		// 获取 user_dto 实体类信息
		UserDto userDto = (UserDto) JwtUtil.analysisToken(token, ParseToken.USER_DTO);
		System.err.println(
				"Token user_dto 实体类信息:\t token:" + userDto.getToken() + "\t id:" + userDto.getId());
	}
}