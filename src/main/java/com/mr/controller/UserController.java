package com.mr.controller;

import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lenovo on 2018/5/30.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //跳转到main页面
    @RequestMapping("/main")
    public String toMainPage(){
        return "main";
    }
    //跳转到list页面
    @RequestMapping("/toListPage")
    public String toListPage(){
        return "list";
    }
    //跳转到add页面
    @RequestMapping("/toAddPage")
    public String toAddPage(){
        return "add";
    }
    //跳转到修改页面，并且通过id查询数据回显
    @RequestMapping("/toUpdatePage/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,ModelMap map){
        User user=userService.selectById(id);
        map.put("user",user);
        return "update";
    }
    //查询
    @GetMapping("/user")
    public String list(ModelMap map){
        List<User> list= userService.list();
        map.put("list",list);
        return "list";
    }
    //删除
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user";
    }
    //增加
    @PostMapping("/user")
    public String add(User user){
        userService.add(user);
        return "redirect:/user";
    }
    //修改
    @PutMapping("/user")
    public String update(User user){
        userService.update(user);
        return "redirect:/user";
    }






}
