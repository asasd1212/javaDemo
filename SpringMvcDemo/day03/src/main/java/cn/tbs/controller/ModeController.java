package cn.tbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModeController {
    @RequestMapping("model")
    public String model(Model model){
        model.addAttribute("username","小红");
        return "hello";
    }
}
