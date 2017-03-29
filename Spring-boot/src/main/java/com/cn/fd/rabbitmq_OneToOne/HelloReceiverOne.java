/**
 * 
 */
package com.cn.fd.rabbitmq_OneToOne;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月15日 下午5:06:01
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiverOne {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  1: " + hello);
    }

}
