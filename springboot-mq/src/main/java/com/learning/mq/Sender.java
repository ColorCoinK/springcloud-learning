package com.learning.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.config.RabbitMQConfig;

/**
 * 消息生产者,通过注入 AmqpTemplate 接口的实例来实现消息的传送
 *
 * @ClassName: Sender
 * @Description: TODO
 * @Created by luohui on 2018/07/17
 */
@Service
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		System.out.println("发送测试消息");
		rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, "Hello,World");
	}
}