package com.brickcat.learn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mzk on 2017/3/30.
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    String hello(){
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host","http://localhost:9090/");
        return "/index";
    }
}
