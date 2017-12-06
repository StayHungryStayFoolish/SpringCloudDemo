# RabbitMQ

## Message Broker

一种消息验证、传输、路由的架构模式。设计目标主要应用于下面场景：

1. 消息路由到一个或多个目的地

2. 消息转化为其他的表现方式

3. 执行消息的聚集、消息的分解，并将结果发送到他们的目的地，然后重新组合响应返回给消息用户

4. 调用 Web 服务来检索数据

5. 响应事件或错误

6. 使用 `发布-订阅` 模式来提供内容或基于主题的消息路由

AMQP 是 Advanced Message Queuing Protocol 简称，它是一个面向消息中间件的开放式标准应用层协议。

AMQP 特性：

1. 消息方向

2. 消息队列

3. 消息路由（包括：点对点和发布-订阅模式）

4. 可靠性

5. 安全性

## RabbitMQ

以 AMQP 协议实现的一种中间件产品，支持多种操作系统，多种编程语言

当前系统安装路径： /usr/local/sbin

启动：

cd /usr/local/sbin

rabbitmq-server

访问 Web 页面：账户名，密码 guest

http://localhost:15672/
