package com.wang.controller;

import com.wang.pojo.User;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/api/menu/user")
    public List<User> listUsers(){
        return userService.list();
    }
}
