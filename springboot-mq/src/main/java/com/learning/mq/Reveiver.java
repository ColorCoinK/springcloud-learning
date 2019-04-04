package com.learning.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费者.通过@RabbitListener 注解定义对对垒的监听
 *
 * @ClassName: Reveiver
 * @Created by luohui on 2018/07/17
 */
@Service
public class Reveiver {

	// @Autowired
	// private AmqpTemplate rabbitTemplate;

	/**
	 * 监听 test-queue 队列
	 *
	 * @param message void
	 * @Title: receiveMessage
	 */
	@RabbitListener(queues = "test-queue")
	public void receiveMessage(String message) {
		System.out.println("Reveived<" + message + ">");
	}

}
