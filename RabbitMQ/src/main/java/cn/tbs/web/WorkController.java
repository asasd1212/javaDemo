package cn.tbs.web;

import cn.tbs.work.WorkProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
    @Autowired
    WorkProducer workProducer;
    @GetMapping("sendwork")
    public String sendWork(){
        workProducer.send();
        return "ok";
    }
}
