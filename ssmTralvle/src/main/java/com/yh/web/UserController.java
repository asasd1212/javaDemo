package com.yh.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Role;
import com.yh.pojo.UserInfo;
import com.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有
     *
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping("findAll")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size,
                          Model model) {
        System.out.println(1111);
        PageHelper.startPage(page, size);

        List<UserInfo> list = userService.findAllUsers();
        PageInfo pageInfo = new PageInfo(list);

        model.addAttribute("pageInfo", pageInfo);

        return "user-list";
    }

    @PostMapping("save")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @GetMapping("findById")
    public String findById(@RequestParam("id") Integer id, Model model){
        System.out.println("findById");
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }

    @GetMapping("findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(@RequestParam("id") Integer id , Model model){
        //得知道给谁进行添加角色
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);

        //根据用户id查询该用户哪些角色可以添加
        List<Role> roleList =  userService.findOtherRole(id);

        model.addAttribute("roleList",roleList);

        return "user-role-add";
    }

    @PostMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam("userId") Integer userId , @RequestParam("ids") Integer[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll";
    }

    @GetMapping("deleteUser")
    public String deleteUser(@RequestParam("id") Integer id){
        //先把用户对应角色关系删除
        userService.deleteUserRole(id);

        //删除用户
        userService.deleteUser(id);

        return "redirect:findAll";
    }
    @ResponseBody
    @GetMapping("getUsername")
    public String getUserName(){
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return user.getUsername();
    }
}
