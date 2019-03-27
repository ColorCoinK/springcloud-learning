package com.learning.controller;

import com.learning.entity.User;
import com.learning.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title null.java$
 * @ClassName UserController
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/13 14:50
 * @Version 1.0
 */
@RestController
@RequestMapping("users")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id, HttpServletRequest request) {
		logger.error(request.getContextPath() + request.getPathInfo() + request.getLocalPort());
		return this.userRepository.findOne(id);
	}

	@GetMapping("/findByIdAndName")
	public User findByIdAndName(@RequestParam(value = "id") Long id,
			@RequestParam("username") String userName) {
		return this.userRepository.findByIdAndName(id, userName);
	}
}