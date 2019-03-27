package com.learning.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Title null.java$
 * @ClassName RabbitMQReceiver
 * @Description RabbitMQ 消息消费者,监听 Hello 队列.使用@RabbitHandler 注解来指定对消息的处理方法。
 * 实现对 Hello 队列的消费,消费操作为输出消息的字符串内容
 * @Author sanss
 * @Date 2019/2/19 11:08
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "Hello")
public class RabbitMQReceiver {

	@RabbitHandler
	public void process(String hello){
		System.out.println("Receiver:"+hello);
	}

}