package cn.tbs.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="workqueue")
public class WorkCustomer {
    @RabbitHandler
    public void receive(String content){
        System.out.println("SimpleQueueCustomer");
        System.out.println("来SimpleQueueProducer的信息："+content);
    }
}
