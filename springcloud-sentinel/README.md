# SpringCloudAlibaba 使用Sentinel实现接口限流

> `TIPS`

* 来源: 程序猿DD —— <a href="http://blog.didispace.com/spring-cloud-alibaba-sentinel-1" target="_blank">使用Sentinel实现接口限流</a>

> 下载

* <a href="https://github.com/alibaba/Sentinel/releases/download/1.4.0/sentinel-dashboard-1.4.0.jar">sentinel-dashboard-1.4.0.jar</a>

> `POINT`

* 配置文件 

  ```yaml
  server:
    port: 7001
  spring:
    application:
      name: alibaba-sentinel
    cloud:
      sentinel:
        transport:
          dashboard: 127.0.0.1:7100
  ```

* 需要启动`sentinel-dashboard` 

  ```
  java -jar sentinel-dashboard-1.4.0.jar --server.port=7100
  ```

* 最好保持版本一致,避免出现其他异常 