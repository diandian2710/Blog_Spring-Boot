package com.wang.service;

import com.wang.mapper.UserMapper;
import com.wang.pojo.*;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

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
    public int register(User user) {
        String username = user.getUsername();
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
//        对 html 标签进行转义，防止 XSS 攻击
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setEnabled(true);

        if (username.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);

        userMapper.save(user);

        return 1;
    }


}
