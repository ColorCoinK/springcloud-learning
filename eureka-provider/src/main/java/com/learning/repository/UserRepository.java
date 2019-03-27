package com.learning.repository;

import com.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Title null.java$
 * @ClassName UserRepository
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/13 14:36
 * @Version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByIdAndName(Long id, String name);
}