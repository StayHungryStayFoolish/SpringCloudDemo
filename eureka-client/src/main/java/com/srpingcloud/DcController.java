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
     * @return
     */
    @GetMapping("/dc")
    public String dc() {
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
