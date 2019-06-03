package com.jql.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jql.entity.User;
import com.jql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello spring-boot";
    }
    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        map.put("name","jql");
        map.put("sex",1);
        List<String> list = new ArrayList<>();
        list.add("sss");
        list.add("aaa");
        map.put("userlist",list);
        return "index";
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(String name,Integer age){
        User u = new User();
        u.setName(name);
        u.setAge(age);
        userMapper.addUser(u);
        return "success";
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectAll();
        PageInfo<User> page = new PageInfo<>(list);
        return page;
    }


}
