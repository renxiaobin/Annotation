package com.rxb.reflect;

/**
 * Created by rxb14 on 2016/2/24.
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        //基本数据类型和void关键字都有自己的类类型
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
        System.out.println(c5.getName());
        System.out.println(c3 == c4);
    }
}
