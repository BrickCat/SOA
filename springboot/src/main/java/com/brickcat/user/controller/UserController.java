package com.brickcat.user.controller;

import com.brickcat.user.moudle.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Seven on 17/4/17.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    //创建线程安全
    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return  "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * @param id
     * @PathVariable是用来对指定请求的URL路径里面的变量 eg: Java代码 @RequestMapping(value = "form/{id}/apply",
     * method = {RequestMethod.PUT, RequestMethod.POST}) {id}在这个请求的URL里就是个变量，
     * 可以使用@PathVariable来获取 @PathVariable和@RequestParam的区别就在于：@RequestParam用来获得静态的URL请求入参
     * @param user
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String pubUser(@PathVariable Long id,@ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }

}
