package com.wang.service;

import com.wang.mapper.AdminPermissionMapper;
import com.wang.mapper.AdminRoleMapper;
import com.wang.mapper.AdminRolePermissionMapper;
import com.wang.pojo.AdminPermission;
import com.wang.pojo.AdminRole;
import com.wang.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AdminPermissionService {
    @Autowired
    AdminRoleMapper adminRoleMapper;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;
    @Autowired
    AdminPermissionMapper adminPermissionMapper;

    public Set<String> listPermissionURLsByUser(String username){
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());
        List<Integer> pids = adminRolePermissionMapper.findAllByRids(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionMapper.findById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());
        return URLs;
    }

    public boolean needFilter(String requestAPI){
        List<AdminPermission> ps = adminPermissionMapper.findAll();
        for (AdminPermission p : ps) {
            if (p.getUrl().equals(requestAPI)){
                return true;
            }
        }
        return false;
    }


}
