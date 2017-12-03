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

# 架构情况

- 一个服务注册中心，eureka server,端口为8761

- eureka-client(service-hi)工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册

- service-ribbon端口为8764,向服务注册中心注册

- 当service-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；

![Ribbon 架构图](img/ribbon.png)