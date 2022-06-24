package com.kobedu.boot.demo01.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterControllerTest {
    /**
     *
     * PathVariable 路径变量
     * RequestHeader 获取请求头
     * RequestParam 获取请求参数
     *
     * param m
     * return
     */
    @GetMapping("/player/{name}")
    public Object getPlayer(@PathVariable("name") String playerName,
//                            @RequestParam("number") Integer num,
//                            @RequestHeader Map header,
                            @RequestHeader("User-Agent") String userAgent
//                           , @CookieValue Map<String,String> cookies
    )  {
        HashMap map = new HashMap();
        map.put("球员名",playerName);
//        map.put("号码",num);
//        map.put("cookies",cookies);
        System.out.println("通过注解请求头的相关信息：  "+userAgent);
       return map;
    }
    /*
    通过注解去传递参数(获取参数) 可以直接从url路径获取参数以前我们参数的写法 url/?key=value 现在可以直接 写在url中就像前面的案例一样
    @PathVariable("name") String playerName
    我们也可以通过注解获取参数@RequestParam("number") Integer num,在URL传参时参数名一定要和指定的一一对应否则接收不到参数
    上面的两种获取参数的方式也可以直接获取参数的map映射。
    如果需要我们也可以通过注解获取请求头相关的信息
    */


    /*
     为什么在方法的形参那里获取（通过注解）Cookie时在客户端的页面包400状态码？？
    */

//    使用错误参数不匹配，状态码415
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(@RequestBody String requestBody){
        System.out.println("请求体的详细：---->"+requestBody);//为什么明明我传的是中文，他怎么就变成奇怪的样子反正我是没看懂！！>userName=%E8%B4%A2%E6%97%BA%E6%8B%89%E7%8F%8D&password=TVLmPmj43cwzh9f&inter=%E6%88%96%E8%AE%B8%E5%9C%A8%E5%A5%B9%E5%BF%83%E9%87%8C%E6%88%91%E5%8F%AA%E4%B8%8D%E8%BF%87%E6%98%AF%E4%B8%AA%E5%8F%AF%E6%9C%89%E5%8F%AF%E6%97%A0%E7%9A%84%E4%BA%BA
        return requestBody;
    }

    /*矩阵变量的测试*/
    @GetMapping("/testM/{user}")
    public Object test(@MatrixVariable("userName") String userName,
                       @MatrixVariable("password") String password,
                       @MatrixVariable("inter") List<String> inters){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        map.put("inters",inters);
        return map;
    }


    @GetMapping("/goto")
    public String testGoto(HttpServletRequest request){
        request.setAttribute("mes","我哪有这么小气");
        return "forward:/suc";
    }
    @GetMapping("/suc")
    public Object suc(@RequestAttribute("mes") String mes){
        Map<String,Object> map = new HashMap<>();
        map.put("mes",map);
        return map;
    }

}
