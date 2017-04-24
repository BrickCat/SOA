package com.brickcat.learn.controller;


import com.brickcat.exception.MyException;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mzk on 2017/3/30.
 */
@Controller
public class HelloWorldController {

    @ApiOperation(value = "测试异常",notes = "请求异常")
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String hello() throws Exception{
        throw new Exception("发生错误");
    }

    @ApiOperation(value = "自定义捕获异常",notes = "")
    @RequestMapping("/json")
    public String json() throws Exception{
        throw new MyException("哎呀，出错了！");
    }
    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host","http://localhost:9090/");
        return "/index";
    }
}
