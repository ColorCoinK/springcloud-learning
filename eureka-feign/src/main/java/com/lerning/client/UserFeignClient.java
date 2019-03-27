package com.lerning.client;

import com.lerning.client.UserFeignClient.UserFeignClientFallback;
import com.lerning.entity.User;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Title null.java$
 * @ClassName UserFeignClient
 * @Description 服务提供者调用类 \n `@FeignClient`的 name、url 等属性支持占位符,例如(`@FeignClient(name
 * ="${feign.name}")`)
 * @Author sanss
 * @Date 2019/2/14 16:33
 * @Version 1.0
 */
@FeignClient(name = "microsevice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {


	@GetMapping("/users/{id}")
	User queryUserInfoById(@PathVariable("id") Long id);


	/**
	 * @return com.lerning.entity.User
	 * @Title queryUserInfoByIdAndName
	 * @Description GET 请求多参数的URL写法一
	 * <link src="http://www.itmuch.com/spring-cloud-sum/feign-multiple-params/" />
	 * @Param
	 **/
	@GetMapping("/users/findByIdAndName")
	User queryUserInfoByIdAndName(@RequestParam("id") Long id,
			@RequestParam("username") String userName);

	@GetMapping("/users/findByIdAndName")
	User queryUserInfoByIdAndName(@RequestParam Map<String, Object> param);

	// 服务降级
	@Component
	class UserFeignClientFallback implements UserFeignClient {

		@Override
		public User queryUserInfoById(Long id) {
			return new User(id, "默认用户", 1);
		}


		@Override
		public User queryUserInfoByIdAndName(Long id, String userName) {
			return new User(id, "默认用户", 1);
		}

		@Override
		public User queryUserInfoByIdAndName(Map<String, Object> param) {
			return new User(1L, "默认用户", 1);
		}
	}


}