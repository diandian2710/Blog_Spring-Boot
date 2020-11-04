package com.wang;

import com.wang.mapper.*;
import com.wang.pojo.AdminMenu;
import com.wang.pojo.AdminRoleMenu;
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
    @Test
    void test(){
//        List<AdminMenu> allByParentId = adminMenuService.getAllByParentId(0);
//        System.out.println(allByParentId);

        List<AdminMenu> menusByRoleId = adminMenuService.getMenusByRoleId(1);
        System.out.println(menusByRoleId);

    }

}
