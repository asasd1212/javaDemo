package cn.tbs.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.management.MXBean;
@Component
public class TopicQueueConfig {
    @Bean
    public Queue getTopicOne(){
        return  new Queue("topic1");
    }

    @Bean
    public Queue getTopicTwo(){
        return new Queue("topic2");
    }

    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindTopicOne(){
        return BindingBuilder.bind(getTopicOne()).to(getTopicExchange()).with("order.addOrder");
    }

    @Bean
    public Binding bindTopicTwo(){
        return BindingBuilder.bind(getTopicTwo()).to(getTopicExchange()).with("pay.*");
    }
}
