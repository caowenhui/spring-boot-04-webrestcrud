package com.cao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author cwh
 * @Date 2019/2/21 0:16.
 */
@Controller
public class HelloController {

    /*@RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        //classpath:/templates/success.html
        return "success";
    }


}
