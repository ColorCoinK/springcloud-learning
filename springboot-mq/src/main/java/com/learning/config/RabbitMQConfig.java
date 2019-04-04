package com.learning.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册消息队列
 *
 * @ClassName: RabbitMQConfig
 * @Created by luohui on 2018/07/17
 */
@Configuration
public class RabbitMQConfig {

	// 消息队列名称
	public static final String QUEUE_NAME = "test-queue";

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}

}
