package com.yh.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Permission;
import com.yh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

@GetMapping("findAll")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") Integer page ,
                          @RequestParam(value = "size",defaultValue = "5") Integer size,
                          Model model){
    PageHelper.startPage(page,size);
    List<Permission> all = permissionService.findAll();
    PageInfo pageInfo = new PageInfo(all);
    model.addAttribute("pageInfo",pageInfo);
    return "permission-list";
}

@PostMapping("save")
    public String save(Permission permission){
    permissionService.save(permission);
    return "redirect:findAll";
}
}
