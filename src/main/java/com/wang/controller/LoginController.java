package com.wang.controller;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import com.wang.result.Result;
import com.wang.result.ResultFactory;
import com.wang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @CrossOrigin
    @PostMapping("/api/login")
    public Result login(@RequestBody User requestUser) {
        System.out.println("the user is++++======" + requestUser);
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.findByUsername(username);
            if(!user.isEnabled()){
                return ResultFactory.buildFailResult("This user has been banned");
            }
            return ResultFactory.buildSuccessResult(username);
        } catch (IncorrectCredentialsException e) {
            String message = " invalid password";
            return ResultFactory.buildFailResult(message);
        }catch (UnknownAccountException e){
            return ResultFactory.buildFailResult("this username is not existed");
        }
    }



@PostMapping("/api/register")
public Result register(@RequestBody User user) {
    int status = userService.register(user);
    switch (status) {
        case 0:
            return ResultFactory.buildFailResult("用户名和密码不能为空");
        case 1:
            return ResultFactory.buildSuccessResult("注册成功");
        case 2:
            return ResultFactory.buildFailResult("用户已存在");
    }
    return ResultFactory.buildFailResult("未知错误");
}


    @GetMapping("api/logout")
    public Result logout(){
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            String message = "成功登出";
            return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping("api/authentication")
    public String authentication(){
        return "身份认证成功";
    }

}
