package com.wang.mapper;

import com.wang.pojo.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRoleMapper {
    AdminRole findById(@Param("id") int id);
    List<AdminRole> findAllById(List<Integer> rids);
}
