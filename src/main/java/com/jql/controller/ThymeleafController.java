package com.jql.controller;

import com.jql.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {
    @RequestMapping(value = "/index")
    public String index(Map map){
        map.put("name","laijunqiang");
        map.put("company","smy");
        map.put("age",22);
        map.put("message","hello world");
        List<User> users = new ArrayList<>();
        users.add(new User(1,"a",11));
        users.add(new User(2,"b",12));
        users.add(new User(3,"c",13));
        users.add(new User(4,"d",14));
        map.put("users",users);
        return "index";
    }

}
