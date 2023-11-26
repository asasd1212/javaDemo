package cn.tbs.web;

import cn.tbs.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @Autowired
    TopicProducer topicProducer;
    @GetMapping("sendtopic")
    public String sendTopic(){
        topicProducer.sendTopic();
        return "ok";
    }
}
