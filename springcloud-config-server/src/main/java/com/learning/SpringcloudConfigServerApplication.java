package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigServerApplication.class, args);
	}

}

