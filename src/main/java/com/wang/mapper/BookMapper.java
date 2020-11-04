package com.wang.mapper;

import com.wang.pojo.Book;
import com.wang.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    List<Book> findAllByCategory(@Param("category") Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(@Param("title") String keyword1, @Param("author") String keyword2);
    int deleteById(@Param("id") Integer id);
    List<Book> findAll();
    int save(Book book);
}
