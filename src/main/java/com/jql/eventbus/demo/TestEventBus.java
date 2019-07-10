package com.jql.eventbus.demo;

import com.google.common.eventbus.EventBus;

public class TestEventBus {
    public static void main(String[] args) {
/*        EventBus eventBus = new EventBus();
        eventBus.register(new TestListener());*/
        EventBus eventBus = EventBusFactory.getInstance();
        TestListener listener = TestListener.getTestListener();
        eventBus.post(new TestEvent("hello smy"));
        eventBus.post(new TestEvent("hashiqi"));
        eventBus.post(new TestEvent("shoushou"));
        eventBus.post(new TestEvent("mad word"));
        System.out.println("<----------------->");
        eventBus.post(new TestEvent1("mad word"));
        eventBus.post(new TestEvent1("mad word"));
        eventBus.post(new TestEvent1("mad word"));
        System.out.println("<----------------->");
        eventBus.post(new TestEvent2("mad word"));
        eventBus.post(new TestEvent2("mad word"));
        eventBus.post(new TestEvent2("mad word"));
        eventBus.post(new TestEvent2("mad word"));
    }
}
