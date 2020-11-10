package com.wang.service;

import com.wang.mapper.AdminPermissionMapper;
import com.wang.mapper.AdminRoleMapper;
import com.wang.mapper.AdminRolePermissionMapper;
import com.wang.pojo.AdminPermission;
import com.wang.pojo.AdminRole;
import com.wang.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    AdminRolePermissionService adminRolePermissionService;

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

    public List<AdminPermission> listPermissionByRoleId(int rid){
        ArrayList<AdminPermission> nullList = new ArrayList<>();
        List<Integer> rids = adminRolePermissionService.findAll()
                .stream().map(AdminRolePermission::getRid).collect(Collectors.toList());
        if (rids.contains(rid)){
            List<Integer> pids = adminRolePermissionService.findAllByRid(rid)
                    .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
            return adminPermissionMapper.findById(pids);
        }else {
            return nullList;
        }
    }

    public List<AdminPermission> list() {return adminPermissionMapper.findAll();}



}
