package com.wang.mapper;

import com.wang.pojo.AdminRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRolePermissionMapper {
    List<AdminRolePermission> findAllByRid(@Param("rid") int rid);
    List<AdminRolePermission> findAllByRids(List<Integer> rids);
    List<AdminRolePermission> findAll();
    void deleteAllByRid(@Param("rid") int rid);
    int saveAll(List<AdminRolePermission> rps);
    int save(AdminRolePermission rp);
}
