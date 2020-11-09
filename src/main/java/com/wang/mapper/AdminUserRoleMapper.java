package com.wang.mapper;

import com.wang.pojo.AdminUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminUserRoleMapper {
    List<AdminUserRole> findAllByUid(@Param("uid") int uid);
    void deleteAllByUid(@Param("uid") int uid);
    int saveAll(List<AdminUserRole> urs);

}
