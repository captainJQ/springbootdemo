package com.jql.eventbus.demo;

public class TestEvent1 {
    private String message;

    public TestEvent1(String message) {
        this.message = message;
        System.out.println("event happened:"+message);
    }

    public String getMessage() {
        return message;
    }
}
