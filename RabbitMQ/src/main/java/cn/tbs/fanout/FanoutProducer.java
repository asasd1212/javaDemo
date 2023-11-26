package cn.tbs.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

public void send(){
    System.out.println("xxx订单信息发送");
    rabbitTemplate.convertAndSend("fanoutExchange","order","order message");


    System.out.println("xxx订单付款信息");
    rabbitTemplate.convertAndSend("fanoutExchange","pay","pay message");
}
}
