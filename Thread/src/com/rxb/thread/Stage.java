package com.rxb.thread;

/**
 * Created by rxb14 on 2016/3/1.
 */
public class Stage extends Thread {
    public void run(){
        System.out.println("欢迎收看隋唐演义！");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民军");

        //启动线程
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //Stage线程休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣，半路杀出个程咬金");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");

        //停止线程运行
        //如果使用stop方法停止程序运行，会使得程序戛然而止，直接中断当前的操作，不推荐
        //当线程处于阻塞状态时（例如调用了sleep方法），若使用interrupt方法中断线程，该线程中断状态会被清除
        //此时isInterrupted方法不能返回正确的值，且sleep方法会抛出中断异常，所以也不推荐使用interrupt方法停止线程
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        //留出时间给mrCheng线程运行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mrCheng.start();

        //join方法让所有线程等待mrCheng完成运行
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，人民安居乐业！");
        System.out.println("谢谢观看，再见！");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
