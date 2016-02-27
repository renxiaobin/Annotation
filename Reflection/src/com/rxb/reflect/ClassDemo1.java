package com.rxb.reflect;

/**
 * Created by rxb14 on 2016/2/23.
 */
public class ClassDemo1 {

    public static void main(String[] args) {
        //A类的实例对象
        A a1 = new A();//al是A类的实例对象

        //A类其实也是一个类的实例对象，这个类就是Class
        //任何一个类都是Class的实例对象，有以下三种表示方式
        //c1和c2表示了A类的类类型（class type）

        //第一种表达方式，也表明了任何一个类都有一个隐含的静态成员变量class
        Class c1 = A.class;

        //第二种表达方式，已知A类的实例对象通过getClass方法获得
        Class c2 = a1.getClass();

        //相等，因为一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("com.rxb.reflect.A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c3 == c2);

        //通过一个类的类类型可以创建该类的实例对象，即通过c1、c2去创建A类的实例对象
        try {
            A a2 = (A)c1.newInstance();//但是需要该类有无参数的构造方法
            a2.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
class A {
    void print(){
        System.out.println("A");
    }
}