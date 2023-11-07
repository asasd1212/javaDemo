package cn.tbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("to")
public class PageController {
    @RequestMapping("{page}")
    public String getPage(@PathVariable("page") String page) {
        return page;
    }
}
