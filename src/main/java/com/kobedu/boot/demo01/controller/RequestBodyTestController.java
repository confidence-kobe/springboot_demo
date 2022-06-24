package com.kobedu.boot.demo01.controller;

import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestBodyTestController {

    @RequestMapping("/gotodemo")
    public String test01(HttpServletRequest request){
        request.setAttribute("mes","我有那么小气吗");
        return "forward:/demo02";
    }

    /*返回请求体和响应体的区别是什么*/
    @ResponseBody
    @RequestMapping("/demo02")
    public  Object demo02(@RequestAttribute("mes") String mes
                           , HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("mes",mes);
        String mes1 = (String) request.getAttribute("mes");
        map.put("mes1",mes1);
        System.out.println(map);
        return map;
    }
}
