package com.wang.controller;

import com.wang.result.Result;
import com.wang.result.ResultFactory;
import com.wang.service.AdminRoleMenuService;
import com.wang.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    AdminRoleMenuService adminRoleMenuService;
    @Autowired
    AdminRoleService adminRoleService;

    @GetMapping("/api/admin/role")
    public Result listRoles(){
        return ResultFactory.buildSuccessResult(adminRoleService.listWithPermsAndMenus());
    }
}
