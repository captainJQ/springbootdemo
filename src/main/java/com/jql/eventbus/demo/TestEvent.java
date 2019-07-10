package com.jql.eventbus.demo;

public class TestEvent {
    private String message;

    public TestEvent(String message) {
        this.message = message;
        System.out.println("event happened:"+message);
    }

    public String getMessage() {
        return message;
    }
}
