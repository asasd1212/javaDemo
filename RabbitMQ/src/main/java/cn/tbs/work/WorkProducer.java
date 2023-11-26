package cn.tbs.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(){
        System.out.println("工作队列模式的生产者");
        for(int i = 0;i<6;i++){
            rabbitTemplate.convertAndSend("","workqueue","workqueue消息");
        }


    }
}
