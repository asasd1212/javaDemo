package cn.tbs.direct;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    DirectExchange directExchange;

    public void sendDirect(){
        System.out.println("直连模式的生产者");
        rabbitTemplate.convertAndSend("directExchange","order","order message");
        rabbitTemplate.convertAndSend("directExchange","pay","pay message");
    }
}
