package com.jql.hutool.demo;

import cn.hutool.extra.mail.MailUtil;


public class MailDemo {
    public static void main(String[] args) {
        new Thread(()->{
            int a = 0;
            while (true){
                if(a++>10){
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MailUtil.sendText("huangtai@smyfinancial.com","test send mail","hello world  hahhhhhh",null);
            }
        }).start();

    }
}
