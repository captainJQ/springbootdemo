package com.jql.hutool.demo;

import cn.hutool.extra.mail.MailUtil;


public class MailDemo {
    public static void main(String[] args) {
        new Thread(()->{
/*            int a = 0;
            while (true){
                if(a++>10){
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                MailUtil.sendText("1424544054@qq.com","test send mail","花开如火，也如寂寞。",null);
/*            }*/
        }).start();

    }
}
