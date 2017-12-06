package com.springcloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by bonismo@hotmail.com
 * 上午10:55 on 17/12/6.
 * <p>
 * 消息消费者
 *
 * @RabbitListener(queues="发送端定义的消息队列名字") 该注解对消息队列的监听
 * @RabbitHandler 该注解指定对消息的处理方式
 */
@Component
@RabbitListener(queues = "Hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }
}
