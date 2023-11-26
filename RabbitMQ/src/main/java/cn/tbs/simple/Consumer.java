package cn.tbs.simple;

import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@RabbitListener(queues = "workqueue")
public class Consumer {
    public static void main(String[] args) throws Exception {
        //1. 创建连接工厂（设置RabbitMQ的连接参数）；
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机；默认localhost
        connectionFactory.setHost("localhost");
        //连接端口；默认5672
        connectionFactory.setPort(5672);
        //用户名；默认guest
        connectionFactory.setUsername("yl");
        //密码；默认guest
        connectionFactory.setPassword("123");
        //2. 创建连接；
        Connection connection = connectionFactory.newConnection();
        //3. 创建频道；
        Channel channel = connection.createChannel();
        channel.queueDeclare(Producer.QUEUE_NAME, true, false, false, null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者"+new String(body));
            }
        };
    channel.basicConsume(Producer.QUEUE_NAME,true,defaultConsumer);
    }
}
