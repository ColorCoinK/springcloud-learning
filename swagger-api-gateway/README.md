# 网关整合 SpringCloud(Dalston.SR5 版本) 集成 Swagger API 文档配置类

- 需要启动 Eureka-Server 服务注册中心
- 采用`Spring4all社区版的自定义Swagger包`,其他版本依赖可能与当前使用方法不一致,请查找其他资料

## 项目创建

 1. 创建`SpringBoot`项目,本示例选择`spring-boot-starter-parent 1.5.12.RELEASE`、`spring-cloud-dependencies Dalston.SR5`;
 2. 使用`Eureka`做服务注册中心
 3. 使用`zuul` 路由配置

## 导入依赖

```xml
  <dependency>
    <groupId>com.spring4all</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
    <version>1.7.0.RELEASE</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
  </dependency>
```

## 启动类增加注解

```java
  @EnableSwagger2Doc
  @EnableZuulProxy
```

## 创建配置文件类,配置`API`文档

```java
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
```

## 配置文件,设置注册中心,项目端口等

```yaml
spring:
  application:
    name: api-gateway

server:
  port: 1101

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1001/eureka/
```

