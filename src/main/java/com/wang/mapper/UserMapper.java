package com.wang.mapper;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User findByUsername(@Param("username") String username);

    User getByUsernameAndPassword(@Param("username") String username,@Param("password")String password);

    int addUser(User user);

    List<User> findAll();

    int save(User user);
}
