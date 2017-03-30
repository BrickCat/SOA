package com.brickcat.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mzk on 2017/3/30.
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    String hello(){
        return "Hello World";
    }

}
