package com.jql.eventbus.demo;

import com.google.common.eventbus.EventBus;

public class EventBusFactory {

    private static EventBus eventBus;

    public static EventBus getInstance(){
        if(eventBus==null){
            synchronized (EventBusFactory.class){
                if(eventBus==null){
                    eventBus = new EventBus();
                }
            }
        }
        return eventBus;
    }
}
