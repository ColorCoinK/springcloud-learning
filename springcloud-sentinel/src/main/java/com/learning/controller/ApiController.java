package com.learning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ApiController
 * @Description <br/> 测试API接口
 * @Author Dew
 * @Date 2019/4/9 11:11
 * @Version 1.0
 **/
@RestController
public class ApiController {

	@RequestMapping(value = "/sentinel")
	protected String sentinel() {
		return "调用 sentinel";
	}

}