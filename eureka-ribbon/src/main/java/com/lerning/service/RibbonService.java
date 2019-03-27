package com.lerning.service;

import com.lerning.entity.Book;
import com.lerning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Title null.java$
 * @ClassName RibbonService
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/14 14:42
 * @Version 1.0
 */
@Service
public class RibbonService {

	@Autowired
	private RestTemplate restTemplate;


	public User queryUserInfoBy(Long id) {
		return this.restTemplate.getForObject("http://microsevice-provider-user/users/"+id, User.class);
	}

	public Book queryBookInfoById(Long id) {
		return this.restTemplate.getForObject("http://microsevice-provider-user/"+id, Book.class);
	}
}