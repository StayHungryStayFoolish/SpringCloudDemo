package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bonismo@hotmail.com
 * 上午12:37 on 17/12/4.
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    // @HystrixCommand 包装方法函数时，除了定义服务降级外，
    // Hystrix 框架会自动为这个函数实现调用隔离。
    // 依赖隔离、服务降级 在使用适合是一体化实现的。
    // 利用 Hystrix 来实现服务容错保护在编程模型上非常方便。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name, String.class);
    }

    // 服务降级
    public String hiError(String name) {
        return "Hi , " + name + " Sorry, Error !";
    }
}

/*
对于RestTemplate的使用，我们的第一个url参数有一些特别。
这里请求的host位置并没有使用一个具体的IP地址和端口的形式，
而是采用了服务名的方式组成。那么这样的请求为什么可以调用成功呢？
因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，
自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
 */