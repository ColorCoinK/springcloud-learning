package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		// Ribbon + RestTemplate 的重试
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory =new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(1000);
		simpleClientHttpRequestFactory.setReadTimeout(1000);
		return new RestTemplate(simpleClientHttpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonApplication.class, args);
	}

}

