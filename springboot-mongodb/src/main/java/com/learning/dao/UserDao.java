package com.learning.dao;

import com.learning.entity.UserEntity;

/**
 * @ClassName: UserDao
 * @Description: TODO
 * @Created by luohui on 2018/07/17
 */
public interface UserDao {

	void saveUser(UserEntity user);

	UserEntity findUserByUserName(String userName);

	int updateUser(UserEntity user);

	void deleteUserById(Long id);

}
