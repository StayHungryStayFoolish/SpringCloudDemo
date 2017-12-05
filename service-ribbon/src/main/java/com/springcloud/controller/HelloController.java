package com.springcloud.controller;

import com.springcloud.service.HelloService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bonismo@hotmail.com
 * 下午6:43 on 17/12/3.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    RestTemplate restTemplate;

    // 如果调用 consumer 方法，需要在主程序中注释掉  @LoadBalanced，该注解才有效
    // 不然 status=404
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/consumer")
    public String consumer() {
        // choose(); 使用负载均衡选出 "eureka-client" 的一个服务实例
        // 服务实例的基本信息存储在 ServiceInstance 中
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()+"/dc";
        System.out.println("URL==>"+url);
        return restTemplate.getForObject(url, String.class);
    }

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
