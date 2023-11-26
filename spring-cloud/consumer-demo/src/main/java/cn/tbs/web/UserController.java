package cn.tbs.web;

import cn.tbs.api.UserClient;
import cn.tbs.fallback.UserClientFallback;
import cn.tbs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/user")
public class UserController {
    @Autowired
    UserClient userClient;

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id")String id){
        User user = userClient.queryById(id);
        return user;
    }
}
