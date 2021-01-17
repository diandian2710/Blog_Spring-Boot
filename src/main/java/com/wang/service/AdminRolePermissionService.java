package com.wang.service;

import com.wang.mapper.AdminRolePermissionMapper;
import com.wang.pojo.AdminPermission;
import com.wang.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;

    List<AdminRolePermission> findAllByRid(int rid){
        return adminRolePermissionMapper.findAllByRid(rid);
    }

    List<AdminRolePermission> findAll(){
        return adminRolePermissionMapper.findAll();
    }

    @Transactional
    public void savePermChanges(int rid, List<AdminPermission> perms){
        adminRolePermissionMapper.deleteAllByRid(rid);
        ArrayList<AdminRolePermission> rps = new ArrayList<>();
        if (!perms.isEmpty()){
            perms.forEach(p->{
                AdminRolePermission rp = new AdminRolePermission();
                rp.setRid(rid);
                rp.setPid(p.getId());
                rps.add(rp);
            });
            adminRolePermissionMapper.saveAll(rps);
        }
//        perms.forEach(p->{
//            AdminRolePermission rp = new AdminRolePermission();
//            rp.setRid(rid);
//            rp.setPid(p.getId());
//            adminRolePermissionMapper.save(rp);
//        });
    }

}
