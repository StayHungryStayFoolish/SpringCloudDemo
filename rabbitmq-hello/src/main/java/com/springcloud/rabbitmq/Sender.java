package com.springcloud.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 上午10:51 on 17/12/6.
 * <p>
 * AmqpTemplate 接口定义了一套针对 AMQP 协议的基础操作。
 * <p>
 * 消息发送者
 */
@Component
public class Sender {

    // 注入 AmqpTemplate 接口，来实现消息发送
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "Hello" + new Date();
        System.out.println("Sender : " + context);
        // convertAndSend(消息队列名字，消息内容);
        this.rabbitTemplate.convertAndSend("Hello", context);
    }
}
