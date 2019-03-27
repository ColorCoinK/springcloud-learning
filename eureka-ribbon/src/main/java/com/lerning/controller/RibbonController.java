package com.lerning.controller;

import com.lerning.entity.Book;
import com.lerning.entity.User;
import com.lerning.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title null.java$
 * @ClassName RibbonController
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/14 14:49
 * @Version 1.0
 */
@RestController
@RequestMapping("ribbon")
public class RibbonController {

	@Autowired
	private RibbonService ribbonService;


	@GetMapping("/user/{id}")
	public User queryUserInfoById(@PathVariable Long id) {
		return this.ribbonService.queryUserInfoBy(id);
	}

	@GetMapping("/book/{id}")
	public Book queryBookInfoById(@PathVariable Long id) {
		return this.ribbonService.queryBookInfoById(id);
	}
}