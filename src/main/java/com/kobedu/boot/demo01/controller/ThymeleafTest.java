package com.kobedu.boot.demo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafTest {
    @RequestMapping("/thy")
    public String test01(Model model){
        model.addAttribute("msg","正在使用thymeleaf进行测试！");
        return "helloty";
    }
}

