package com.rxb.reflect;

import java.lang.reflect.Method;

/**
 * Created by rxb14 on 2016/2/24.
 */
public class MethodDemo {
    public static void main(String[] args) {
        B b1 = new B();
        Class c1 = b1.getClass();

        //根据方法名和参数列表获取方法对象
        //可变参数可以用数组也可以一个一个列出
        try {
            //c1.getMethod("print",new Class[]{int.class,int.class})
            Method m1 = c1.getMethod("print", int.class, int.class);
            b1.print(10, 20);
            //m1.invoke(b1,new Object[]{10,20});
            m1.invoke(b1,10,20);

            System.out.println("============");

            //c1.getMethod("print",new Class[]{String.class,String.class})
            Method m2 = c1.getMethod("print", String.class, String.class);
            b1.print("hello", "world");
            //m2.invoke(b1,new Object[]{"hello","world"});
            m2.invoke(b1, "hello", "world");

            System.out.println("============");

            //c1.getMethod("print",new Class[]{})
            Method m3 = c1.getMethod("print");
            b1.print();
            //m3.invoke(b1,new Object[]{});
            m3.invoke(b1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class B{
    public void print(){
        System.out.println("Hello");
    }
    public void print(int a,int b){
        System.out.println(a + b);
    }
    public void print(String a,String b){
        System.out.println(a + b);
    }
}
