package com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类, 不使用@Configuration 注解是可以在 SwaggerApplication.class 中使用@Import注解代替
 *
 * @ClassName: Swagger2Config
 * @Description: TODO
 * @Created by luohui on 2018/07/19
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	/**
	 * 第一组 API
	 */
	private final String BASEPACKAGE = "com.learning.controller";

	private final String BASEPACKAGE2 = "com.learning.group";

	/**
	 * 定义单个 API
	 */
	@Bean
	public Docket createApi() {

		return new Docket(DocumentationType.SWAGGER_2)
				       .groupName("用户相关API")
				       .genericModelSubstitutes(DeferredResult.class)
				       .useDefaultResponseMessages(false)
				       .forCodeGeneration(true)
				       .apiInfo(apiInfo())
				       .select()
				       .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE))
				       .paths(PathSelectors.any())
				       .build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				       .title("SpringBoot 官方版 Swagger 构建RESTful文档")
				       .description("SpringBoot应用在线调试文档")
				       .termsOfServiceUrl("http://www.baidu.com")
				       .contact(new Contact("程序员DD", "http://blog.didispace.com", ""))
				       .version("1.0")
				       .build();
	}

	/**
	 * 定义 API 组
	 */
	@Bean
	public Docket innerApi() {
		return new Docket(DocumentationType.SWAGGER_12)
				       .groupName("innerApi")
				       .genericModelSubstitutes(DeferredResult.class)
				       .useDefaultResponseMessages(false)
				       .forCodeGeneration(true)
				       .select()
				       .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE2))
				       .paths(PathSelectors.any())
				       .build()
				       .apiInfo(innerApiInfo());
	}

	private ApiInfo innerApiInfo() {
		return new ApiInfoBuilder()
				       .title("SpringBoot 官方版 Swagger 构建RESTful文档")
				       .description("SpringBoot应用在线调试文档")
				       .termsOfServiceUrl("http://www.baidu.com")
				       .contact(new Contact("程序员DD", "http://blog.didispace.com", ""))
				       .version("1.0")
				       .build();
	}
}
