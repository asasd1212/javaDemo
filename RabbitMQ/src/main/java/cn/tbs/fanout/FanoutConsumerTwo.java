package cn.tbs.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fqueue2")
public class FanoutConsumerTwo {

    @RabbitHandler
    public void receive(String content){
        System.out.println("fanout消费者2"+content);
    }
}
