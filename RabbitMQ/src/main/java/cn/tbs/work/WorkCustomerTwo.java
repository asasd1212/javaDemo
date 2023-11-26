package cn.tbs.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="workqueue")
public class WorkCustomerTwo {
    @RabbitHandler
    public void receive(String content){
        System.out.println("消费者2");
    }
}
