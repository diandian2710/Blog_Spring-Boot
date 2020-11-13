package com.wang.mapper;

import com.wang.pojo.JotterArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JotterArticleMapper {
    JotterArticle findById(@Param("id") int id);
    List<JotterArticle> selectPage();
}
