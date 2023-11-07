package cn.tbs.controller;

import cn.tbs.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @RequestMapping(value = "response",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String response(){
        return"<h1>张三</h1>";
    }


    @RequestMapping(value = "ajaxRequest",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String ajaxRequest(){
    return "李四";
    }

    @RequestMapping(value = "/ajaxRequest2")
    @ResponseBody
    public User response2(@RequestBody User user){
        System.out.println(user);
        user.setUsername("王五");
        return user;
    }
}
