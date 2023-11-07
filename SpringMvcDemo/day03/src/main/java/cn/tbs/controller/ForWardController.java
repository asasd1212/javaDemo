package cn.tbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ForWardController {
    @RequestMapping("hello")
    public String hello(){
        System.out.println(111);
        return "success";
    }

    @RequestMapping("hello2")
    public String hello2(){
        System.out.println(222);
        return "forward:hello.jsp";
    }

    @RequestMapping("hello3")
    public void hello3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/hello").forward(request,response);
        System.out.println(333);
    }
    @RequestMapping("redirect")
    public String hello4(){
        return "redirect:/hello2";
    }
    @RequestMapping("redirect2")
    public void hello5(HttpServletResponse response) throws IOException {
        response.sendRedirect("/hello");
    }
}
