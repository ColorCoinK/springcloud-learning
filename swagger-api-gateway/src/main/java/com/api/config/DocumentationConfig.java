package com.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * API 网关整合 Swagger API 文档配置类
 *
 * @ClassName: DocumentationConfig
 * @Description: TODO
 * @Created by luohui on 2018/07/18
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public List<SwaggerResource> get() {
		List resources = new ArrayList<>();
		resources.add(swaggerResource("service-a", "/swagger-service-a/v2/api-docs", "2.0"));
		resources.add(swaggerResource("service-b", "/swagger-service-b/v2/api-docs", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
