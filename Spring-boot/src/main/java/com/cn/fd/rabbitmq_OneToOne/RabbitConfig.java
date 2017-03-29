/**
 * 
 */
package com.cn.fd.rabbitmq_OneToOne;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月15日 下午5:04:04
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

}
