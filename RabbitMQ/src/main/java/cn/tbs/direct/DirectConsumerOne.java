package cn.tbs.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "directQueue1")
public class DirectConsumerOne {
    @RabbitHandler
    public void receive(String context){
        System.out.println("order消费者"+context);
    }
}
