package com.wang.controller;

import com.wang.pojo.User;
import com.wang.result.Result;
import com.wang.result.ResultFactory;
import com.wang.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
//    @GetMapping("/api/menu/user")
//    public List<User> listUsers(){
//        return userService.list();
//    }
    @RequiresPermissions("/api/admin/user")
    @GetMapping("/api/admin/user")
    public Result listUsers() throws Exception {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    // UserController
    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody User requestUser) {
        userService.editUser(requestUser);
        String message = "修改用户信息成功";
        return ResultFactory.buildSuccessResult(message);
    }


}
