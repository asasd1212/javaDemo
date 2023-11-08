package com.yh.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Permission;
import com.yh.pojo.Role;
import com.yh.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @GetMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "5")Integer size){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("findAll");
        PageHelper.startPage(page,size);
        List<Role> allRoles = roleService.findAllRoles();

        PageInfo<Role> rolePageInfo = new PageInfo<>(allRoles);
        modelAndView.addObject("pageInfo",rolePageInfo );
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @PostMapping("save")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:findAll";
    }

    @GetMapping("findById")
    public String findById(@RequestParam(value = "id")Integer id,Model model){
        Role byId = roleService.findById(id);
        System.out.println(byId);
        model.addAttribute("role",byId);
        return "role-show";

    }
    @PostMapping("addPermissionToRole")
    public String addPermissionToRole(@RequestParam("roleId") Integer roleId ,
                                      @RequestParam("ids") Integer[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll";
    }

    @GetMapping("findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(@RequestParam("id") Integer id, Model model){
        Role byId = roleService.findById(id);
        model.addAttribute("role",byId);


        List<Permission> otherPermission = roleService.findOtherPermission(id);
        model.addAttribute("permissionList", otherPermission);
        return "role-permission-add";
    }

    @GetMapping("deleteRole")
    public String deleteRole(@RequestParam("id") Integer id){
        roleService.deleteRole(id);
        return "redirect:findAll";
    }
}
