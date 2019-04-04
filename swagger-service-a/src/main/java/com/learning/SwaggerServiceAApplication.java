package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class SwaggerServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerServiceAApplication.class, args);
	}
}
