# Spring Cloud 服务调用（二）

# Feign + Eureka 实现负载均衡

# Feign

 - Feign 是一个`声明式` 伪 Http 客户端。

 - 使用 Feign 只需要创建一个`接口`并注解为 @FeignClient 使用 value 标识 服务提供客户端的 name 属性即可

 - 具有可插拔的注解特性，使用 Feign 注解和 JAX-RS 注解。

 - Feign 默认继承 Ribbon，和 Eureka 结合，默认实现`负载均衡`效果

 `Feign 采用基于 接口 的注解，整合了 Ribbon`

# # 创建服务消费

  Spring-Boot Project : service-feign

  pom.xml 引入依赖：

  spring-cloud-starter-eureka

  spring-cloud-starter-feign

  spring-boot-starter-web

  并加入依赖管理，具体见 POM 文件：

  spring-cloud-dependencies

# 启动工程

详情见（一）

# 运行方式，见 Service

# 说明

@RequestMapping 的路由路径对应的是 Eureka-Client 的路由路径

当 Web Controller层 对外暴露 API 时，调用注入的该接口方法，会通过当前路由调用 Eureka-Client 的服务

