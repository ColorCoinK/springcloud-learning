package com.learning.repository;

import com.learning.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Title 用户数据库操作类
 * @ClassName UserRepository
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/22 15:11
 * @Version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<UserPO, Long> {

	/**
	 * @Title findByNameAndPassword
	 * @Description   登录验证
	 * @Param
	     * @param name  登录名
		 * @param password  密码
	 * @return com.learning.entity.Account
	 **/
	UserPO findByNameAndPassword(String name, String password);

}