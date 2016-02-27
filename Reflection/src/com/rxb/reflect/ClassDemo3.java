package com.rxb.reflect;

/**
 * Created by rxb14 on 2016/2/24.
 */
public class ClassDemo3 {
    public static void main(String[] args) {
        String s1 = "123";
        ClassUtil.printClassMethodMessage(s1);

        Integer i1 = 1;
        ClassUtil.printClassMethodMessage(i1);
    }
}
