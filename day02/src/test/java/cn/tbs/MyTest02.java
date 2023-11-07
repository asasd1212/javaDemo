package cn.tbs;

import cn.tbs.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
public class MyTest02 {
    @Autowired
    EmployeeService employeeService;
    @Test
    public void ts1(){
//        employeeService.save();
        employeeService.go("北京");
    }



}
