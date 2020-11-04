package com.wang.mapper;

import com.wang.pojo.AdminPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminPermissionMapper {
    AdminPermission findById(@Param("id") int id);
    List<AdminPermission> findById(List<Integer> pids);
    List<AdminPermission> findAll();
}
