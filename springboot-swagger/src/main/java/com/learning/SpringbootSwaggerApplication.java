package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.battcn.swagger.annotation.EnableSwagger2Doc;

@EnableSwagger2Doc
@SpringBootApplication
public class SpringbootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerApplication.class, args);
		/**
		 SpringApplication application = new SpringApplication(SpringbootSwaggerApplication.class);
		 application.setBannerMode(Banner.Mode.OFF);
		 application.run(args);*/
	}
	/**
	 @Bean public WebMvcConfigurer corsConfigurer() {
	 return new WebMvcConfigurerAdapter() {
	 @Override public void addCorsMappings(CorsRegistry registry) {
	 registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
	 }
	 };
	 }*/
}
