package cn.tbs.controller;



import cn.tbs.pojo.User;
import cn.tbs.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    StockService stockService;

    @GetMapping("getallstocks")
    @ResponseBody
    public List<User> getAllStocks() {
        List<User> users = stockService.finAllStocks();
        for (User user : users) {
            String name = user.getName();
            System.out.println("Name: " + name);
        }
        return users;
    }

    @GetMapping("hello")
    @ResponseBody
    public String test() {
        return "hello";
    }

    @RequestMapping("/findAllStocks")
    public ModelAndView findAllStocks(){
        ModelAndView mv = new ModelAndView("stocklist");
        List<User> stockList = stockService.finAllStocks();
        mv.addObject("stocklist",stockList);
        mv.setViewName("stocks");
        return mv;
    }



    @GetMapping("getStockById/{id}")
    @ResponseBody
    public User getStockById(@PathVariable("id") Integer id){
        System.out.println(id);
        return stockService.getStockById(id);
    }
}
