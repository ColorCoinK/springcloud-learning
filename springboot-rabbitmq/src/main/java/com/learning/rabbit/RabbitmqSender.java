package com.learning.rabbit;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title null.java$
 * @ClassName RabbitMQSender
 * @Description RabbitMQ 消息生产者
 * @Author sanss
 * @Date 2019/2/19 11:00
 * @Version 1.0
 */
@Component
public class RabbitmqSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(){
		String context = "Hello "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("Sender: "+context);
		this.amqpTemplate.convertAndSend("Hello",context);
	}

}