package com.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 处理Ajax请求跨域的问题
 *
 * @ClassName: CorsConfig
 * @Description: 第一种方式, 隐患:当服务器跑出 500 的时候依旧存在跨域问题
 * @Created by luohui on 2018/07/19
 */
@Deprecated
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

	static final String ORIGINS[] = new String[]{"GET", "POST", "PUT", "DELETE"};

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods(ORIGINS)
				.maxAge(3600);
	}
}
