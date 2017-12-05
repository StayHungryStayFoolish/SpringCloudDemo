# Spring Cloud Consul

# Consul

Consul 是 HashiCorp 公司推出的开源工具。

用于实现分布式系统的服务发现与配置。与其他分布式注册与发现方案相比，Consul 方法更`一站式`。

Consul 是用 Go 语言编写，因此天然具有可移植性，与 Docker 等轻量级容器无缝配合。

当前系统位置 /usr/local/bin/consul

**内置了**

- 服务注册与发现框架、

- 分布一致性协议实现、

- 健康检查

- K/V 存储

- 多数据中心方案

`不在需要依赖其他工具，比如（Zookeeper）`

### Consul启动

cd /usr/local/bin/

./consul agent -dev

-dev 表示开发模式运行

  - 该节点启动不能用于生产环节，因为该模式下不会持久化任何状态，该模式只为了快速启动单节点 consul

-server 表示服务模式运行

### 查看 Consul 节点信息

consul members

Address : 节点地址

Status : alive 表示节点监控

Type : server 表示是 server 运行模式

DC : dc1 表示该节点属于 DataCenter1

### Consul 访问地址 http://127.0.0.1:8500/ui/ 和 Eureka-Server 界面差不多

### 停止服务

CTRL + C

该节点离开后，会通知 cluster 中的其他节点

# Consul 常用命令

|命令|解释|实例|
|---|:---:|:---:|
|agent|运行一个 consul agent|consul agent -dev|
|join|将 agent 加入 consul 集群|consul join IP|
|members|列出 consul cluster 集群中的 members|consul members|
|leave|将节点移除所在集群|consul leave|