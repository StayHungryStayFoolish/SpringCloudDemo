package com.springcloud;

import com.springcloud.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class RabbitmqHelloApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() {
		sender.send();
	}

}

/**
 测试结果：

 Sender : HelloWed Dec 06 11:25:59 CST 2017
 Receiver : HelloWed Dec 06 11:25:59 CST 2017
 */
