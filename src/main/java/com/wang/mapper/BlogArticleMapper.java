package com.wang.mapper;

import com.wang.pojo.BlogArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogArticleMapper {
    BlogArticle findById(@Param("id") int id);
    List<BlogArticle> selectPage();
}
