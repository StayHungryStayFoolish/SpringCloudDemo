package com.srpingcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableEurekaClient
 * 该注解表明自己是服务客户端，可以向服务中心注册，服务中心会接收信息
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

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
}

/**
 *
 * @RequestMapping 的路由路径对应的是 Service-Feign 的 Service 接口路由路径
 * http://localhost:8762/hi?name=springcloud
 * http://localhost:8763/hi?name=springcloud
 *
 * name 后边任意值
 */
