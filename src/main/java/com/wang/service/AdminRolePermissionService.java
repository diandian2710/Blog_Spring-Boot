package com.wang.service;

import com.wang.mapper.AdminRolePermissionMapper;
import com.wang.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;

    List<AdminRolePermission> findAllByRid(int rid){
        return adminRolePermissionMapper.findAllByRid(rid);
    }

}
