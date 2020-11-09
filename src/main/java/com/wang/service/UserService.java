package com.wang.service;

import com.wang.mapper.UserMapper;
import com.wang.pojo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleService adminRoleService;

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
        List<User> users = userMapper.findAll();
//        for (User user : users) {
//            List<AdminRole> roles = adminRoleService.listRolesByUser(user.getUsername());
//            user.setRoles(roles);
//        }

        users.forEach(user -> {
            List<AdminRole> roles = adminRoleService.listRolesByUser(user.getUsername());
            user.setRoles(roles);
        });
        return users;
    }

    public void editUser(User user){
        User userInDB = userMapper.findByUsername(user.getUsername());
        userInDB.setName(user.getName());
        userInDB.setPhone(user.getPhone());
        userInDB.setEmail(user.getEmail());
        userMapper.save(userInDB);
        adminUserRoleService.saveRoleChanges(userInDB.getId(), user.getRoles());
    }


}
