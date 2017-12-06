package com.srpingcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bonismo@hotmail.com
 * 上午11:08 on 17/12/5.
 */
@RestController
public class DcController {

    @Value("${server.port}")
    private String port;

    /**
     * 对外暴露服务 API
     * @param name url请求参数
     * @return
     */
    @RequestMapping(value = "/hi")
    public String home(@RequestParam String name) {
        return "ClientName is " + name + " , I am from port: " + port;
    }

    // Warning,But can running
    // Spring Cloud 对服务治理做的一层抽象，可以屏蔽 Eureka 和 Consul 服务治理的实现细节
    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * getServices(); 源码是 List
     *
     * Thread.sleep(); 为了触发 Hystrix 的服务降级，简单加5秒延迟
     * 场景模拟触发 Hystrix 服务降级：
     * 1.启动 Eureka-Server、Eureka-Client、Eureka-Ribbon-Hystrix。
     * 2.当访问 localhost:8766/hi?name=spring-ribbon-hystrix，会触发服务降级。
     * 因为服务提供方输出了原本要返回的结果，但是由于返回前延迟了5秒，所以服务消费方触发了
     * 服务请求超时异常，服务消费者就通过 HystrixCommand 注解中指定的降级逻辑进行执行。
     *
     * 该机制，对自身服务起到了基础的保护，同时还为异常情况提供了自动的服务降级切换机制。
     *
     * @return
     */
    @GetMapping("/dc")
    public String dc() throws InterruptedException {
//        Thread.sleep(5000L);
        String services = "Services : " + discoveryClient.getServices();
        System.out.println("Services --> "+services);
        return services;
    }

    /**
     *
     * @RequestMapping 的路由路径对应的是 Service-Feign 的 Service 接口路由路径
     * http://localhost:8762/hi?name=springcloud
     * http://localhost:8763/hi?name=springcloud
     *
     * name 后边任意值
     */

}
