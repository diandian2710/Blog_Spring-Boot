package com.wang.mapper;

import com.wang.pojo.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMenuMapper {
    List<AdminMenu> findAllById(List<Integer> menuIds);
    List<AdminMenu> findAllByParentId(@Param("parentId") int parentId);
}
