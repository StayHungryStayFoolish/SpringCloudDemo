package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @EnableDiscoveryClient
 * 向服务中心注册
 * @EnableFeignClients
 * 注解会开启 Feign 功能
 * @EnableHystrixDashboard
 * 注解会开启断路器监控器
 * URL: http://localhost:8767/hystrix
 */
@EnableHystrixDashboard
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignHystrixApplication.class, args);
	}
}
