package cn.tbs.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic2")
public class TopicConsumerTwo {
    @RabbitHandler
    public void receive(String content) {
        System.out.println("支付消费者2" + content);
    }
}
