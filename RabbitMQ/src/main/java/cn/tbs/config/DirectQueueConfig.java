package cn.tbs.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectQueueConfig {
    @Bean
    public Queue getDirectOne(){
        return new Queue("directQueue1");
    }

    @Bean
    public Queue getDirectTwo(){
        return new Queue("directQueue2");
    }

    @Bean
    public DirectExchange getDirectExchange(){
        return  new DirectExchange("directExchange");
    }

    @Bean
    public Binding bingDirectOne(){
        return BindingBuilder.bind(getDirectOne()).to(getDirectExchange()).with("order");
    }

    @Bean
    public Binding bingDirectTwo(){
        return BindingBuilder.bind(getDirectTwo()).to(getDirectExchange()).with("pay");
    }
}
