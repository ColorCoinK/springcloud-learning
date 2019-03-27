# 使用 `Ribbon` 消费`RESTful API` 

**注：**

1. 使用`RestTemplate` 调用 `API` 时,`url`为服务提供者的 `spring.application.name` 而不是 `ip:port`;
2. 调用的 `url` 需要确保无误,否则会调用失败.

- 实现了`Ribbon + RestTemplate` 重试

参考 <a href="http://www.itmuch.com/spring-cloud-sum/spring-cloud-retry/" target="_blank">周立-SpringCloud 各组件重试总结</a>