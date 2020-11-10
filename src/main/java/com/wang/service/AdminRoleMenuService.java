package com.wang.service;

import com.wang.mapper.AdminRoleMenuMapper;
import com.wang.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    // AdminRoleMenuService
    @Transactional
    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        adminRoleMenuMapper.deleteAllByRid(rid);
        List<AdminRoleMenu> rms = new ArrayList<>();
        for (Integer mid : menusIds.get("menusIds")) {
            AdminRoleMenu rm = new AdminRoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            rms.add(rm);
        }

        adminRoleMenuMapper.saveAll(rms);
    }

}
