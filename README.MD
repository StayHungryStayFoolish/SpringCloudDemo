# Spring Cloud 服务的注册与发现

# Main Project

建立一个 Maven 主工程

# Eureka Server

建立一个发现服务的集群工程

URL:

http://localhost:8761

# Eureka Client

建立一个服务客户端

**一个服务启动多个实例**

更改 resources 下的 application.yml port 配置
然后再次运行 EurekaclientApplication ，不要重启当前服务

URL:

http://localhost:8762/hi?name=***

name 后边随便填写
