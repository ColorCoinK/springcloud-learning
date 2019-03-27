# 基于 Eureka 搭建鉴权服务(jjwt Token认证)

  * 需要启动服务注册中心,eureka-server

## 说明
  
  * 只是码了这部分代码,原理及详细的解释可阅读尾部的链接地址

## 项目结构

```
src-main
      |
      |
    java
      |
       ---  entity
              |
               -- dto
                   |
                    -- UserDto  Token 刷新时间实体类
              |
               -- UserPO  用户数据库映射实体类
              |
              |
            enumerate
              |
               -- ParseToken Token 包含的内容解析
              |
            repository
              |
                -- UserRepository 用户数据库相关操作
              |
            utils
              |
               -- JwtUtil 生成、解析、刷新 Token 工具类
              |
            EurekaTokenServerApplication
      |
    resources
      |
        -- application.yml  主配置文件
        -- data.sql 初始化数据SQL
        -- schema.sql 建表语句SQL
      

```
## 功能概述

1. Eureka 服务注册中心
2. 签发Token

## 架构分析

1. Eureka 服务注册中心
2. Eureka 客户端
3. jjwt 签发token
4. H2 内存数据库
5. JPA 操作数据库

> 参考文章列表

1. <a href="https://blog.battcn.com/2017/08/15/springcloud/dalston/spring-cloud-security-jwt/" target="_blank"> 唐亚峰 —— SpringCloud-服务认证(JWT)</a>
2. <a href="https://www.javazhiyin.com/35020.html" target="_blank">Java知音 - 单点登录原理与简单实现</a>