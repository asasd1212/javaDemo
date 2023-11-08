package com.yh.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Product;
import com.yh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("product")
public class productController {
    @Autowired
    private ProductService productService;

    @GetMapping("findAll")
    public String getAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "5") Integer size, Model model) {
        PageHelper.startPage(page, size);
        List<Product> list = this.productService.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "product-list";
    }

    @PostMapping("save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:findAll";
    }


    /**
     * 修改之前进行查询
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("findById")
    public String finfProductById(@RequestParam("id") Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-show";
    }
    @GetMapping("editById")
    public String editById(@RequestParam("id") Integer id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-edit";
    }
    @PostMapping("edit")
    public String edit(Product product){
        productService.edit(product);
        return "redirect:findAll";
    }


    @GetMapping("deleteById")
    public String deleteById(@RequestParam("id")Integer id){
        productService.deleteById(id);
        return "redirect:findAll";
    }
    @PostMapping("selectDelete")
    private String selectDelete(int[]ids){
        System.out.println(Arrays.toString(ids));
        for (int id : ids){
            productService.deleteById(id);
        }
        return "redirect:findAll";
    }
}