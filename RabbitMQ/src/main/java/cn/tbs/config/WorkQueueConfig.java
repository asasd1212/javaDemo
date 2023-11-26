package cn.tbs.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkQueueConfig {
    @Bean
    public Queue getQueue(){
        return new Queue("workqueue",false,false,false,null);
    }
}
