package cn.tbs.topic;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    TopicExchange topicExchange;
    public void sendTopic(){
        System.out.println("主题模式生产者开始发送订单消息了");
        rabbitTemplate.convertAndSend(topicExchange.getName(),"order.addOrder","订单添加信息");
        rabbitTemplate.convertAndSend(topicExchange.getName(),"pay.findPay","查询支付信息");

    }
}
