package com.jql.mapper2;

import com.jql.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper2 {
    @Select("insert into user (name,age) values(#{name},#{age})")
    public void addUser(User user);
    @Select("select * from user")
    List<User> selectAll();
}
