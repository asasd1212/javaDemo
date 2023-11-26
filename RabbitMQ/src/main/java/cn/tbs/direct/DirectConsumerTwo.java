package cn.tbs.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "directQueue2")
public class DirectConsumerTwo {
    @RabbitHandler
    public void receive(String context){
        System.out.println("order消费者2"+context);
    }
}
