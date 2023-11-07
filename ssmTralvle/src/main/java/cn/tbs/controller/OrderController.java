package cn.tbs.controller;

import cn.tbs.pojo.Member;
import cn.tbs.pojo.Orders;
import cn.tbs.pojo.Product;
import cn.tbs.pojo.Traveller;
import cn.tbs.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    MemeberService memeberService;
    @Autowired
    TravellerService travellerService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderAndTravellerService orderAndTravellerService;
    @GetMapping("findAll")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size, Model model) {
        System.out.println(1111);
        PageHelper.startPage(page, size);
        List<Orders> all = orderService.findAll();
        PageInfo<Orders> objectPageInfo = new PageInfo<>(all);
        model.addAttribute("pageInfo", objectPageInfo);
        return "order-list";
    }

    @GetMapping("findById")
    public String findById(@RequestParam("id") Integer id, Model model) {
        System.out.println(id);
   Orders orders = orderService.findById(id);
        System.out.println(orders);
    model.addAttribute("order",orders);
        return "order-show";
    }
    @GetMapping("add")
    public String toAdd(Model model){
        List<Member> all = memeberService.findAll();
        List<Traveller> all1 = travellerService.findAll();
        List<Product> all2 = productService.findAll();
        model.addAttribute("productList",all2);
        model.addAttribute("memberList",all);
        model.addAttribute("travellerList",all1);
        all.forEach(System.out::println);
//        all1.forEach(System.out::println);
        all2.forEach(System.out::println);
        return "order-add";
    }

    @PostMapping("save")
    public String save(Orders orders){
        orderService.save(orders);
        Integer OrderId = orderService.findByOrderNum(orders.getOrderNum());
        orderAndTravellerService.add(OrderId,orders.getTravellerId());
        return "redirect:findAll";
    }
}
