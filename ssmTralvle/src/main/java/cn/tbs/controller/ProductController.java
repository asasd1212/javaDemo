package cn.tbs.controller;

import cn.tbs.pojo.Product;
import cn.tbs.service.ProductService;
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
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("findAll")
public String findAll(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "size",defaultValue = "5")Integer size, Model model){
        PageHelper.startPage(page,size);

        List<Product> users = productService.findAll();
        //System.out.println(users);
        PageInfo<Product> productPageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo",productPageInfo);
        System.out.println(productPageInfo);

        return "product-list";
    }
    @PostMapping("save")
    public String save(Product product){
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll";
    }

    @GetMapping("findById")
    public  String findProductById(@RequestParam("id")Integer id ,Model model){
        System.out.println(111);
        Product byId = productService.findById(id);
        model.addAttribute("product",byId);
        return "order-show";
    }

    @GetMapping("editById")
    public String editById(@RequestParam("id") Integer id,Model model){
        Product byId = productService.findById(id);
        model.addAttribute("product",byId);
        return "product-edit";

    }

    @PostMapping("edit")
    public String edit(Product product){
        productService.edit(product);
        return  "redirect:findAll";
    }
    @GetMapping("deleteById")
    public String deleteById(@RequestParam("id") Integer id){
        System.out.println(id);
        productService.updateById(id);
        productService.deleteById(id);
        return "redirect:findAll";
    }
    @PostMapping("selectDelete")
    public String selectDelete(int[]ids){
        for (int id : ids) {
            productService.updateById(id);
            productService.deleteById(id);
        }
        return "redirect:findAll";
    }
}
