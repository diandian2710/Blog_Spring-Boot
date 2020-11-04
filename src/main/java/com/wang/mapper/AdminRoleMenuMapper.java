package com.wang.mapper;

import com.wang.pojo.AdminRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminRoleMenuMapper {
    List<AdminRoleMenu> findAllByRid(@Param("rid") int rid);
    List<AdminRoleMenu> findAllByRids(List<Integer> rids);
    void deleteAllByRid(int rid);
}
