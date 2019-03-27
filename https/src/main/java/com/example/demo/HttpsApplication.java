package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpsApplication.class, args);
	}

	@RequestMapping(value = "getHttps/{name}")
	public String https(@PathVariable(value = "name") String name) {
		return "Hello " + name;
	}
}
