package cn.tbs.web;

import cn.tbs.direct.DirectProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectController {
    @Autowired
    DirectProducer directProducer;
    @GetMapping("senddirect")
    public String send(){
        directProducer.sendDirect();
        return "ok";
    }
}
