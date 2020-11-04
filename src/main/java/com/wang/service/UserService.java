package com.wang.service;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getByName(String username){
        return userMapper.findByUsername(username);
    }
    public boolean isExist(String username){
        User user = getByName(username);
        return null!=user;
    }

    public User get(String username, String password){
        return userMapper.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userMapper.addUser(user);
    }

    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    public List<User> list(){
        return userMapper.findAll();
    }
}
