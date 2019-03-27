package com.learning.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title null.java$
 * @ClassName RabbitConfig
 * @Description RabbitMQ 配置类 配置队列、交换器、路由等
 * @Author sanss
 * @Date 2019/2/19 11:12
 * @Version 1.0
 */
@Configuration
public class RabbitConfig {

	@Bean
	public Queue helloQueue() {
		return new Queue("Hello");
	}

}