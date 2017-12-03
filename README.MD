# Spring Cloud 服务的注册与发现

# Main Project

- SpringCloudDemo 主工程

  - SpringBoot 创建方式

    1. new project

    2. spring initializr

        name: 自定义

        type: maven/gradle

        package: jar

    3. spring version: 选择

       web: web

    4. 可以选择删除 src 文件夹，因为并不会使用

# Eureka Server Module

-  Eureka Server 服务注册中心

    - SpringServer 创建方式

        1. new module

        2. spring initializr

        3. Cloud Discovery

            Eureka Server

        4. 具体配置见 Pom.xml

- EurekaServer(服务注册中心) 从每个 EurekaClient(服务客户端)的实例接收消息。
  如果接收时间超时，通常会将该实例从注册中心删除。

- URL: http://localhost:8761

# Eureka Client Module

- Eureka Client 服务提供客户端

    - SpringServer 创建方式，同上

- 一个服务启动多个实例**

    更改 resources 下的 application.yml port 配置
    然后再次运行 EurekaclientApplication ，不要重启当前服务

    URL: http://localhost:8762/hi?name=***

    name 后边随便填写

- EurekaClient(服务提供客户端)，向 EurekaServer(服务注册中心)注册时，
  会提供一些`元数据`，例如：`主机名字`，`端口`，`URL`，`主页`等。

### 推荐 Resources 文件夹内的格式采用 properties，yml 格式要求太严格，容易出问题