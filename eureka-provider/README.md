# 基于 `Eureka` 搭建 服务提供者  

本项目是一个基于 `SpringBoot 1.5.12.RELEASE`、`SpringCloud Dalston.SR5`、`H2`、`Eureka` 的服务提供者.

- 使用`H2`内存数据库初始化测试数据

**注:**
 
1. `SpringBoot 2.x`不能像 1.x 一样,使用 `spring.datasource.schema/data` 指定初始化脚本.否则与 `actuator` 不能共存
2. 项目中的依赖并不是与[参考的博客一样,自行选择]
3. 项目参考来源`http://book.itmuch.com/2 Spring Cloud/2.2 服务提供者.html`

## `Eureka` 常见问题配置参考链接  

<a href="http://www.itmuch.com/spring-cloud-sum-eureka/" target="_blank">Spring Cloud中，Eureka常见问题总结(周立)</a>

## 实现监控(SpringBoot Actuator) 

1. 添加`Actutor` 监控(SpringBoot 1.x 版本)

```xml
添加 Actutor 依赖
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```

- 参考示例: 
  
<a href="http://www.itmuch.com/spring-cloud/finchley-3/" target="_blank">SpringBoot 集成Actutor</a>

**注：** 

1. `SpringBoot 1.x`版本访问`http://10.18.13.2:2001/health`,`SpringBoot 2.x`访问`http://10.18.13.2:2001/actutor/health`
2. 通过 `spring.appliccation.name:server.port` 访问 API 时,需要在 `C:\Windows\System32\drivers\etc\hosts` 文件夹中添加
```
127.0.0.1 microsevice-provider-user
```