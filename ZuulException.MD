# Zuul 异常处理

## Zuul 的声明周期图

图片来自官方：---

![](img/ZuulLifeCycle.png)

实线表示请求必然经过的路径，而虚线表示可能会经过的路径。

- 所有请求都必然按照 `pre` -> `route` -> `post` 顺序执行。

- 如果 `pre` 中自定义 filter，则执行自定义 filter。

- 如果 `pre`，`route`，`post` 发送错误执行 `error`，然后再执行 `post`。

请求进入 `Zuul` 之后的整个调用链：

`ZuulServlet # service` -> `FilterProcess # processZuulFilter` -> `ZuulFilter # runFilter` -> `ZuulFilter # run`