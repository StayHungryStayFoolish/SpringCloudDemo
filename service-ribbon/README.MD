# Spring Cloud 服务调用（一）

# Ribbon + TestTemplate

Ribbon 是一个负载均衡客户端，控制 HTTP 和 TCP 一些行为

# 创建服务消费

Spring-Boot Project : service-ribbon

pom.xml 引入依赖：

spring-cloud-starter-eureka

spring-cloud-starter-ribbon

spring-boot-starter-web

并加入依赖管理，具体见 POM 文件：

spring-cloud-dependencies

# 工程启动

1. 启动 eureka-server 服务注册发现中心

    1.1  resources 下端口：8761  URL: http://localhost:8761

2. 启动 eureka-client 服务客户端

    2.1  resources 下端口：8762，运行工程类程序 `主方法` 创建一个实例 instance

    2.2  resources 下端口：8763，运行工程类程序 `主方法` 创建一个实例 instance

3. 启动 server-ribbon 服务消费

    3.1  resources 下端口：8764

# Ribbon 主要实现方法

- 通过注册一个 Bean : RestTemplate ，SpringCloud 会注入到 IOC 容器内

- 通过在业务层 Service ，调用 getForObject(); 方法传入 服务客户端 URL 参数
  来消费提供的服务。

- Web 层，注入 Service 层，直接调用方法。

# 业务流程大致情况

1. 调用 Service-Ribbon 暴露的 API

2. Service-Ribbon 向服务中心注册

3. 同时 Service-Ribbon 通过 restTemplate 调用接口，通过 Ribbon 进行负载均衡，轮流访问 Eureka-Client 的实例 instance

# 架构情况

![Ribbon 架构图](img/ribbon.png)