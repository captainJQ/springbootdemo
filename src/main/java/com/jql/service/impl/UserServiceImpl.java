package com.jql.service.impl;

import com.jql.entity.User;
import com.jql.mapper1.UserMapper1;
import com.jql.mapper2.UserMapper2;
import com.jql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper1 userMapper1;
    @Autowired
    private UserMapper2 userMapper2;
    @Override
    public Integer addUser(User user) {
        userMapper2.addUser(user);
        userMapper1.addUser(user);
        return 0;
    }
}
