package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.learning.rabbit")
@SpringBootApplication
public class SpringbootRabbitmq {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmq.class, args);
	}

}
