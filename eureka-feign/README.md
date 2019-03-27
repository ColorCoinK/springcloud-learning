# `Feign` 自定义配置`[细粒度配置]`  

> 自定义日志级别 

- 默认 Feign 是不打印任何日志的,开启 Feign 日志,Feign 日志有四种级别
  
  * NONE[性能最佳,适用于生产]: 不记录任何日志(默认值)
  * BASIC[适用于生产环境追踪问题]: 仅记录请求方法、URL、响应状态码及响应时间
  * HEADERS: 记录 BASIC 级别的基础上,记录请求和响应的 header
  * FULL[比较适用于开发及测试环境定位问题]: 记录请求和响应的 header、body 和元数据

**注:**

1. 配置参考博客 <a href="http://www.itmuch.com/spring-cloud/finchley-10/" target="_blank">Feign配置自定义`[细粒度配置]`</a>

> `Feign` 使用 `Hystrix` 配置

- 配置 Feign 相关 Hystrix 配置

**注:**

1. 配置参考博客 <a href="http://www.itmuch.com/spring-cloud/finchley-14/" target="_blank">周立-`Feign使用Hystrix`</a>

- 配置监控端点并实现可视化监控数据  

> `Ribbon` 的饥饿加载(eager-load)模式  

problem:  

  在使用`SpringCloud`的`Ribbon`或`Feign`来实现服务调用的时候,如果我们的机器或网络环境等原因不是很好,有时候后会出现
  : 服务消费方调用服务提供方接口时,第一次请求经常会超时,而之后调用就没有问题了.
  
 **注:** 
 
 解决方式参考 <a href="http://blog.didispace.com/spring-cloud-tips-ribbon-eager/" target="_blank">翟永超-Ribbon的饥饿加载模式</a> 
 
 
 > `Feign` 的重试
 
 参考 <a href="http://www.itmuch.com/spring-cloud-sum/spring-cloud-retry/" target="_blank">周立-SpringCloud 各组件重试总结</a>