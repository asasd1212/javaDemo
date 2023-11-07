package cn.tbs;

import cn.tbs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TS {
    @Autowired
    AccountService accountService;

    @Test
    public void ts1(){
        accountService.transfer("罗志祥","蝴蝶姐",100.0);
    }
}
