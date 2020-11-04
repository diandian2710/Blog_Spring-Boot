package com.wang.mapper;

import com.wang.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
    Category findById(@Param("id") int id);
    List<Category> findAll();
}
