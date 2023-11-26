package cn.tbs.controller;

import cn.tbs.pojo.User;
import cn.tbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class userController {
    @Autowired
    UserService userService;
    @RequestMapping("add")
    public String add(){
        System.out.println(111);
        return  "111";
    }


    @GetMapping("findByUserName")
    @ResponseBody
    public boolean findByUserName(User user){
        System.out.println(user.getUsername());
        User byUserName = userService.findByUserName(user.getUsername());
        System.out.println(byUserName);
        if(byUserName != null){
            return false;
        }else{
            return true;
        }
    }
}
