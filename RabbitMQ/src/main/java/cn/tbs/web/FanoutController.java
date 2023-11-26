package cn.tbs.web;

import cn.tbs.fanout.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FanoutController {
    @Autowired
    FanoutProducer fanoutProducer;
    @GetMapping("sendfanout1")
    public String sendFaount(){
        fanoutProducer.send();
        return "ok";
    }
}
