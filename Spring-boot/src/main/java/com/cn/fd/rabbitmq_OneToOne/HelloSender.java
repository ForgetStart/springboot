/**
 * 
 */
package com.cn.fd.rabbitmq_OneToOne;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月15日 下午5:05:15
 */
@Component
public class HelloSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(int i) {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context + "**************" + i);
		this.rabbitTemplate.convertAndSend("hello", context + "**************" + i);
	}

}
