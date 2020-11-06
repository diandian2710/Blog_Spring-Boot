package com.wang.service;

import com.wang.mapper.AdminMenuMapper;
import com.wang.pojo.AdminMenu;
import com.wang.pojo.AdminRoleMenu;
import com.wang.pojo.AdminUserRole;
import com.wang.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {

    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;
    @Autowired
    AdminMenuMapper adminMenuMapper;

    public List<AdminMenu> getAllByParentId(int parentId){
        return adminMenuMapper.findAllByParentId(parentId);
    }

    public List<AdminMenu> getMenuByCurrentUser(){
        //从数据库中获取当前的用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findByUsername(username);

        //获得当前用户对应的所有的角色的id列表
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        // 查询出这些角色对应的所有菜单项
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuMapper.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // 处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    public List<AdminMenu> getMenusByRoleId(int rid) {
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rid)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuMapper.findAllById(menuIds);

        handleMenus(menus);
        return menus;
    }
    /**
     * Adjust the Structure of the menu.
     *
     * @param menus Menu items list without structure
     *
     * 整合查询出的菜单数据的思路如下：
     * 遍历菜单项，根据每一项的 id 查询该项出所有的子项，并放进 children 属性
     * 剔除掉所有子项，只保留第一层的父项。比如 c 是 b 的子项，b 是 a 的子项，我们最后只要保留 a 就行，因为 a 包含了 b 和 c
     */

    public void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
    }

}
