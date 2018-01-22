package com.example.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entity.User;





@RestController
public class helloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    @RequestMapping("/test")
    public String test() {
        return "H";
    }
    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        user.setName("小明");
       // user.setPassWord("xxxx");
        return user;
    }

}
