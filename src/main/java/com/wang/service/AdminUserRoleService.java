package com.wang.service;

import com.wang.mapper.AdminUserRoleMapper;
import com.wang.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;
    public List<AdminUserRole> listAllByUid(int uid){
        return adminUserRoleMapper.findAllByUid(uid);
    }


}
