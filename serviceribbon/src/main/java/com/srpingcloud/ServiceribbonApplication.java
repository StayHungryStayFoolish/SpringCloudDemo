package com.srpingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient
 * 向服务中心注册，并且向程序的 IOC 注入一个 Bean: restTemplate
 * 并通过
 * @LoadBalanced
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceribbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceribbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
