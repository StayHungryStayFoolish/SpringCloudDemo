package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient
 * 该注解向 EurekaServer(服务中心)注册
 * @EnableHystrix
 * 该注解开启 Hystrix 断路器
 */
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonHystrixApplication.class, args);
	}


	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
