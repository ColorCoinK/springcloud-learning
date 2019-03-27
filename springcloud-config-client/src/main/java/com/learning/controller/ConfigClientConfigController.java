package com.learning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title null.java$
 * @ClassName ConfigClientConfigController
 * @Description SpringCloud 分布式文件配置中心
 * @Author sanss
 * @Date 2019/2/15 16:53
 * @Version 1.0
 */
@RestController
public class ConfigClientConfigController {

	@Value("${spring.cloud.config.profile}")
	private String profile;

	@GetMapping("/profile")
	public String getProfile(){
		return this.profile;
	}
}