package com.jql.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }
}
