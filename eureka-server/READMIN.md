# 基于 Eureka 搭建高可用(双节点服务注册中心)

> 添加`pom`依赖

```xml
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
  <java.version>1.8</java.version>
  <spring-cloud.version>Edgware.SR5</spring-cloud.version>
</properties>

<dependencies>
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
  </dependency>
</dependencies>

<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>${spring-cloud.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

> 版本说明 

* 本项目是一个基于 SpringBoot(1.5.19.RELEASE)、SpringCloud(Edgware.SR5)、Eureka 的服务注册中心

## 配置文件

> `application.yml` 
  
单个 `Eureka` 服务注册中心

> `application-colony.yml` 
  
双节点注册中心,实现双向注册从而提高可用性详细可以看<a href="http://www.ityouknow.com/springcloud/2017/05/10/springcloud-eureka.html">注册中心Eureka</a>

1. 默认使用 `application.yml` 配置文件;

2. 使用`application-conlony.yml` 配置文件时,需要指定激活的配置项.(例如启动`server-1`,需运行`java -jar xx.jar --spring.profiles.active=server-1`)