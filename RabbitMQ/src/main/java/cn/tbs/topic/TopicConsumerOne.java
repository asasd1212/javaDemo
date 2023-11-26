package cn.tbs.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic1")
public class TopicConsumerOne {
    @RabbitHandler
    public void receive(String content) {
        System.out.println("订单消费者1" + content);
    }
}
