package com.srpingcloud.controller;

import com.srpingcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bonismo@hotmail.com
 * 上午12:16 on 17/12/3.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}

/**
 *
 一个服务注册中心，eureka server,端口为8761
 eurekaclient工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
 sercvice-ribbon端口为8764,向服务注册中心注册
 当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；
 */
