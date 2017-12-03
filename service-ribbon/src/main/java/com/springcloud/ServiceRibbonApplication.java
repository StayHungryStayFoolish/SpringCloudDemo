package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient
 * 该注解向 EurekaServer(服务中心)注册，
 * 并且向程序 IOC 注入一个 Bean: restTemplate
 * 通过 @LoadBalanced 注解表明当前 restTemplate 开启负载均衡功能
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

/**
 运行当前 Main 程序，并访问 http://localhost:8764/hi?name=service-ribbon
 刷新页面，会显示不同端口号。

 ClientName is service-ribbon , I am from port: 8762
 ClientName is service-ribbon , I am from port: 8763

 证明 RestTemplate 的 @LoadBalanced 已经做了负载均衡

 调用的是 restTemplate.getForObject(); 方法。
 具体架构看 README.MD 文档

 */