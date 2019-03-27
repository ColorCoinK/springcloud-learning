package com.learning.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.learning.dao.UserDao;
import com.learning.entity.UserEntity;
import com.mongodb.WriteResult;

/**
 * @ClassName: UserDaoImpl
 * @Description: TODO
 * @Created by luohui on 2018/07/17
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 创建对象
	 *
	 * @Title: saveUser
	 * @see com.learning.dao.UserDao#saveUser(com.learning.entity.UserEntity)
	 */
	@Override
	public void saveUser(UserEntity user) {
		mongoTemplate.save(user);
	}

	/**
	 * 根据用户名查询对象
	 *
	 * @Title: findUserByUserName
	 * @see com.learning.dao.UserDao#findUserByUserName(java.lang.String)
	 */
	@Override
	public UserEntity findUserByUserName(String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
		UserEntity info = mongoTemplate.findOne(query, UserEntity.class);
		return info;
	}

	/**
	 * 更新对象
	 *
	 * @Title: updateUser
	 * @see com.learning.dao.UserDao#updateUser(com.learning.entity.UserEntity)
	 */
	@Override
	public int updateUser(UserEntity user) {
		Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update().set("userName", user.getUserName())
				                .set("password", user.getPassWord());
		// 更新查询返回结果集的第一条
		WriteResult result = mongoTemplate.updateFirst(query, update, UserEntity.class);
		/// mongoTemplate.updateMulti(query, update, UserEntity.class);
		if (result != null) {
			return result.getN();
		}
		return 0;
	}

	/**
	 * 删除对象
	 *
	 * @Title: deleteUserById
	 * @see com.learning.dao.UserDao#deleteUserById(java.lang.Long)
	 */
	@Override
	public void deleteUserById(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, UserEntity.class);
	}

}
