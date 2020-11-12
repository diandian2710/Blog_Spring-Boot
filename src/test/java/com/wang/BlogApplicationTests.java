package com.wang;

import com.wang.mapper.*;
import com.wang.pojo.*;
import com.wang.service.AdminMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;

    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;
    @Test
    void contextLoads() {
        List<Integer> rids = new ArrayList<>();
        rids.add(1);
        rids.add(2);
        rids.add(3);
        rids.add(4);
        System.out.println(rids);

        List<AdminRoleMenu> allByRid = adminRoleMenuMapper.findAllByRids(rids);
        System.out.println(allByRid);


    }

    @Autowired
    AdminMenuMapper adminMenuMapper;
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    AdminPermissionMapper adminPermissionMapper;
    @Test
    void test(){
//        List<AdminMenu> allByParentId = adminMenuService.getAllByParentId(0);
//        System.out.println(allByParentId);

        List<AdminMenu> menusByRoleId = adminMenuService.getMenusByRoleId(1);
        System.out.println(menusByRoleId);

    }
    @Test
    void test2(){
        ArrayList<Integer> pids = new ArrayList<>();
        pids.add(1);
        pids.add(2);
        pids.add(3);
        List<AdminPermission> byId = adminPermissionMapper.findById(pids);
        System.out.println(byId);
    }

    @Test
    void test3(){
        List<AdminUserRole> urs = new ArrayList<>();
        AdminUserRole ur1 = new AdminUserRole(1, 9);
        AdminUserRole ur2 = new AdminUserRole(1, 3);
        urs.add(ur1);
        urs.add(ur2);
        System.out.println(urs);
        int i = adminUserRoleMapper.saveAll(urs);
        System.out.println("==========>>>>"+i);
    }

    @Test
    void test4(){
        adminRolePermissionMapper.deleteAllByRid(9);
    }

}
