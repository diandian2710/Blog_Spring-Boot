package com.wang.controller;

import com.wang.pojo.AdminMenu;
import com.wang.pojo.User;
import com.wang.service.AdminMenuService;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    UserService userService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu(){
        return adminMenuService.getMenuByCurrentUser();
    }

}
