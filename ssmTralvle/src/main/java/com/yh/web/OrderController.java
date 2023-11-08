package com.yh.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Orders;
import com.yh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
     OrderService orderService;
  @GetMapping("findAll")
  public String findAll(@RequestParam(value = "page" , defaultValue = "1") Integer pager,
                        @RequestParam(value = "size" , defaultValue = "5") Integer size, Model model){
      PageHelper.startPage(pager, size);
      List<Orders> ordersList =  orderService.findAll();
      PageInfo<Orders>pageInfo = new PageInfo<>(ordersList);
      model.addAttribute("pageInfo",pageInfo);
      return "order-list";
  }
}
