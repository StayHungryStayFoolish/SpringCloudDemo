package com.srpingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 服务注册中心注解，用来发现服务的。当服务提供客户端有实例时，注册中心就能接收到。
 * 该注解必须在 SpringBoot 工程启动的 Application 类才能起到作用
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {

        // 第一种启动方式
        SpringApplication.run(EurekaServerApplication.class, args);

        // 第二种启动方式
//		new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
