package com.wang.service;

import com.wang.mapper.AdminRoleMenuMapper;
import com.wang.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    public List<AdminRoleMenu> findAllByRid(int rid){
        return adminRoleMenuMapper.findAllByRid(rid);
    }

    public List<AdminRoleMenu> findAllByRid(List<Integer> rids){
        return adminRoleMenuMapper.findAllByRids(rids);
    }
}
