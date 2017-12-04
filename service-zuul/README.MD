# Spring Cloud 微服务

# 微服务架构，最基础服务治理组件

- 服务注册与发现  Eureka-Server

    - @EnableEurekaServer 服务中心用来发现服务，服务注册

- 服务消费  Eureka-Client

    - @EnableEurekaClient 向服务中心注册，用来提供服务消费

- 负载均衡

    - Service-Ribbon-Hystrix

         - RestTemplate + Ribbon 实现负载均衡

            - @Bean @LoadBalanced 将 RestTemplate 注入到 IOC 容器中，然后 Service 层调用 getForObject(instanceUrl,String.class);

    - Service-Feign-Hystrix

         - Feign + Eureka 实现负载均衡

            - @EnableFeignClients 在主程序注解，表明开启 Feign

            - @FeignClient(value= "instance name") 接口注解

- 断路器

    - Service-Ribbon-Hystrix

        - 程序入口 @EnableHystrix 开启断路器

        - Service 层，方法上加 @HystrixCommand(fallbackMethod = "断路方法名")，定义一个断路方法返回 String


    - Service-Feign-Hystrix

        - Service 接口  @FeignClient 加上 fallback = 该接口实现类.class

        - 实现 Service 接口，重写方法，返回断路后返回的 String 信息。

    - @EnableHystrixDashboard 该注解在主程序默认开启断路器监控

      `URL: http://localhost:端口号/hystrix`

- 智能路由 Zuul

    - 主程序 @EnableZuulProxy 开启 Zuul 路由功能

    - yml 文件配置 routes: 可以配置多个路由

    `此时访问该模块对外暴露的 API 时，分别会以路由路径 path 转发给不同的 服务 serviceId`

    - 该模块实现了一个 ZuulFilter，做了一个 "pre" 前处理。简单实现了必须以 token 为参数的 url 才可以正确访问

- 配置管理

- **

# Zuul 路由网关

URL： http://localhost:8769/api-a/hi?name=zuul&token=***

api-a : yml 文件的 routes名字

token : MyFilter 的前处理内的逻辑

## 启动模式

1. Eureka-Server 服务注册中心

2. Eureka-Client 服务提供客户端

3. Service-Ribbon-Hystrix 负载均衡、断路器

4. Service-Feign-Hystrix 负载均衡、断路器

5. Service-Zuul 智能路由
