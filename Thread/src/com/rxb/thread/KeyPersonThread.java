package com.rxb.thread;

/**
 * Created by rxb14 on 2016/3/1.
 */
public class KeyPersonThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始战斗了！");
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"左突右杀，攻击隋军...");
        }

        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
