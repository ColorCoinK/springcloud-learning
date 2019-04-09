package com.lerning.controller;

import com.lerning.client.BookFeignClient;
import com.lerning.client.UserFeignClient;
import com.lerning.entity.Book;
import com.lerning.entity.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName
 *@Description <br/>
 *  测试Feign调用Controller
 *@Author Dew
 *@Date  2019/2/14 14:42
 *@Version 1.0
 **/
@RestController
@RequestMapping("/feign")
public class UserController {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private BookFeignClient bookFeignClient;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignClient.queryUserInfoById(id);
	}

	@GetMapping("/user/findByIdAndName")
	public User queryUserInfoByIdAndName(@RequestParam("id") Long id,
			@RequestParam("username") String userName) {
		// GET 请求多参数的 URL,参数传递方式一
		// return this.userFeignClient.queryUserInfoByIdAndName(id, userName);

		// GET 请求多参数的 URL 参数传递方式二
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("username", userName);
		return this.userFeignClient.queryUserInfoByIdAndName(param);
	}

	@GetMapping("/book/{id}")
	public Book queryBookInfoById(@PathVariable Long id) {
		return this.bookFeignClient.queryBookInfoById(id);
	}

}