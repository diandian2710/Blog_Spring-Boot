package com.wang.service;

import com.wang.mapper.AdminRoleMapper;
import com.wang.mapper.AdminUserRoleMapper;
import com.wang.pojo.AdminRole;
import com.wang.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;
    public List<AdminUserRole> listAllByUid(int uid){
        return adminUserRoleMapper.findAllByUid(uid);
    }
    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles) {
        adminUserRoleMapper.deleteAllByUid(uid);
        List<AdminUserRole> urs = new ArrayList<>();
        roles.forEach(r -> {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            urs.add(ur);
        });
        adminUserRoleMapper.saveAll(urs);
    }



}
