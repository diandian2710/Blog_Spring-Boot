package com.wang.service;

import com.wang.mapper.BookMapper;
import com.wang.mapper.CategoryMapper;
import com.wang.pojo.Book;
import com.wang.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CategoryMapper categoryMapper;
    public List<Book> list(){
        return bookMapper.findAll();
    }
    public void addOrUpdate(Book book){
        bookMapper.save(book);

    }
    public void deleteById(Integer id){
        bookMapper.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryMapper.findById(cid);
        List<Book> allByCategory = bookMapper.findAllByCategory(category);
        return allByCategory;
    }

    public List<Book> search(String keywords){
        return bookMapper.findAllByTitleLikeOrAuthorLike(keywords,keywords);
//        因为 DAO 里是两个参数，所以在 Service 里把同一个参数写了两遍。用户在搜索时无论输入的是作者还是书名，都会对两个字段进行匹配。
    }



}
