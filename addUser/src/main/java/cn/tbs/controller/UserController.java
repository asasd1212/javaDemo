package cn.tbs.controller;

import cn.tbs.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("findAll")
    public String addUser(){
        System.out.println(111);
        return "success";
    }
}
