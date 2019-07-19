package com.jql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "index";
    }

}
