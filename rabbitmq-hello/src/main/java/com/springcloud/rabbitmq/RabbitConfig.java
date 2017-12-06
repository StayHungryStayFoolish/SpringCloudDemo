package com.springcloud.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bonismo@hotmail.com
 * 上午11:01 on 17/12/6.
 *
 * RabbitMQ 配置类
 * 用来配置队列、交换器、路由等高级信息
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("Hello");
    }
}
