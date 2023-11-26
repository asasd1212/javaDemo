package cn.tbs.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutQueueConfig {
    @Bean
    public Queue getQueueOne(){
        return  new Queue("fqueue1");
    }
    @Bean
    public Queue getQueueTwo(){
        return new Queue("fqueue2");
    }

    //创建交换机
    @Bean
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    public Binding bindingQueueOne(){
        return BindingBuilder.bind(getQueueOne()).to(getFanoutExchange());
    }
    @Bean
    public Binding bindingQueueTwo(){
        return BindingBuilder.bind(getQueueTwo()).to(getFanoutExchange());
    }
}
