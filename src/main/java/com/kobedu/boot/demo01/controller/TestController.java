package com.kobedu.boot.demo01.controller;

import com.kobedu.boot.demo01.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    Person person;

    @RequestMapping("/index")
    public String index(){
        return "hello word!";
    }

    @RequestMapping("/person")
    public Object person(){
        return person;
    }

    @GetMapping("/user")
    public Object getMethod(){
        return "Get";
    }
    @PostMapping("/user")
    public Object postMethod(){
        return "Post";
    }
    @PutMapping("/user")
    public Object putMethod(){
        return "Put";
    }
    @DeleteMapping("/user")
    public Object deleteMethod(){
        return "Delete";
    }

    //自定义filter
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_wc");
        return methodFilter;
    }



}
