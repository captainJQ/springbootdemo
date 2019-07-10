package com.jql.eventbus.demo;

import com.google.common.eventbus.Subscribe;

public class TestListener {
    private static TestListener testListener = new TestListener();
    private String lastMessage;

    public TestListener(){
        EventBusFactory.getInstance().register(this);
    }

    @Subscribe
    public void listen(TestEvent event){
        System.out.println("listener lintening:"+event.getMessage());
    }

    public static TestListener getTestListener(){
        return testListener;
    }
}
