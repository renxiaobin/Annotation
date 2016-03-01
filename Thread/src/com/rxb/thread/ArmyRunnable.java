package com.rxb.thread;

/**
 * Created by rxb14 on 2016/3/1.
 */
public class ArmyRunnable implements Runnable {
    //volatile保证了线程可以正确的读取其他线程写入的值
    volatile boolean keepRunning = true;
    @Override
    public void run() {
        while (keepRunning){
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
                //让出处理器时间，下一次选中谁并不一定
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
