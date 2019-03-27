package com.learning.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.entity.UserEntity;

/**
 * @ClassName: UserDaoTest
 * @Description: TODO
 * @Created by luohui on 2018/07/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void saveUser() {
		UserEntity user = new UserEntity(21L, "周迅", "application");
		userDao.saveUser(user);
	}

	@Test
	public void findUserByUserName() {
		UserEntity user = userDao.findUserByUserName("周迅");
		System.out.println("find user info :\t" + user);
	}

	@Test
	public void updateUser() {
		UserEntity user = new UserEntity(21L, "刘备", "properties");
		userDao.updateUser(user);
	}

	@Test
	public void deleteUserById() {
		userDao.deleteUserById(11L);
	}
}
