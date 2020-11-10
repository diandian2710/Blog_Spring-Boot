package com.wang.service;

import com.wang.mapper.AdminRoleMapper;
import com.wang.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleMapper adminRoleMapper;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminMenuService adminMenuService;

    public List<AdminRole> listRolesByUser(String username){
        int uid = userService.findByUsername(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        return adminRoleMapper.findAllById(rids);
    }

    public  List<AdminRole> listWithPermsAndMenus(){
        List<AdminRole> roles = adminRoleMapper.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermissionByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public AdminRole updateRoleStatus(AdminRole role){
        AdminRole roleInDB = adminRoleMapper.findById(role.getId());
        roleInDB.setEnabled(role.isEnabled());
        int update = adminRoleMapper.save(roleInDB);
        if (update != 0){
            return adminRoleMapper.findById(roleInDB.getId());
        }else {
            return null;
        }
    }
    public void addOrUpdate(AdminRole adminRole){
        adminRoleMapper.save(adminRole);
    }


}
