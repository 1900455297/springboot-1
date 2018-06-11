package com.mr.controller;

import com.mr.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/6/8.
 */
@RestController
public class ClientController {
    /**
     * get 无参访问
     * @return
     */
    @GetMapping("/client/test1")
    public String test1(){
        System.out.println("test1方法被调用！");
        return "success";
    }

    /**
     * get 有参
     * @return
     */
    @GetMapping("/client/test2")
    public String test2(String name,Integer age){
        System.out.println(name+"---------"+age);
        System.out.println("test2方法被调用！");
        return "success";
    }

    @PostMapping("/client/test3")
    public User test3(User user){
        System.out.println(user);
        System.out.println("test3方法被调用！");
        return user;
    }
    @PostMapping("/client/test4")
    public User test4(User user){

        System.out.println("test4方法被调用！");
        return user;
    }

}
