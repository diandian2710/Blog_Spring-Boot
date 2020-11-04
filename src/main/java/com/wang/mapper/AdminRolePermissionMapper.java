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
    void deleteAllById(@Param("rid") int rid);
}
