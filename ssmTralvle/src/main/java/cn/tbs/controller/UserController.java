package cn.tbs.controller;

import cn.tbs.pojo.UserInfo;
import cn.tbs.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;



    @GetMapping("findAll")
    public String findAll(@RequestParam(value = "page",defaultValue = "5") Integer page, @RequestParam(value = "size",defaultValue = "1") Integer size, Model model){
        System.out.println(123123);
        PageHelper.startPage(page,size);
        List<UserInfo> allUsers = userService.findAllUsers();
        System.out.println(allUsers);
        allUsers.forEach(user -> {
            System.out.println(user.getStatusStr());
            System.out.println(user);
        });
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(allUsers);
        model.addAttribute("pageInfo",userInfoPageInfo);
        return "user-list";
    }
}
