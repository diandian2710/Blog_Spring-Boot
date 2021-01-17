package com.wang.controller;

import com.wang.mapper.AdminRoleMapper;
import com.wang.pojo.AdminMenu;
import com.wang.pojo.AdminPermission;
import com.wang.pojo.AdminRole;
import com.wang.pojo.AdminUserRole;
import com.wang.result.Result;
import com.wang.result.ResultFactory;
import com.wang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

        @Autowired
        AdminRoleMenuService adminRoleMenuService;
        @Autowired
        AdminRoleService adminRoleService;
        @Autowired
        AdminPermissionService adminPermissionService;
        @Autowired
        UserService userService;
        @Autowired
        AdminRolePermissionService adminRolePermissionService;

        @GetMapping("/api/admin/role")
        public Result listRoles() {
            return ResultFactory.buildSuccessResult(adminRoleService.listWithPermsAndMenus());
        }

        @PutMapping("/api/admin/role/status")
        public Result updateRoleStatus(@RequestBody AdminRole requestRole) {
            AdminRole adminRole = adminRoleService.updateRoleStatus(requestRole);
            String message = "用户" + adminRole.getNameZh() + "状态更新成功";
            return ResultFactory.buildSuccessResult(message);
        }

        @GetMapping("/api/admin/role/perm")
        public Result listPerms() {
            return ResultFactory.buildSuccessResult(adminPermissionService.list());
    }

    @PutMapping("/api/admin/role")
    public Result editRole(@RequestBody AdminRole requestRole) {
        adminRoleService.addOrUpdate(requestRole);
        adminRolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        String message = "修改角色信息成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @PutMapping("/api/admin/role/menu")
    public Result updateRoleMenu(@RequestParam int rid, @RequestBody Map<String, List<Integer>> menusIds) {
        adminRoleMenuService.updateRoleMenu(rid, menusIds);
        return ResultFactory.buildSuccessResult("更新成功");
    }
}

