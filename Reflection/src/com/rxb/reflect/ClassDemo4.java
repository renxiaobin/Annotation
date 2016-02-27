package com.rxb.reflect;

/**
 * Created by rxb14 on 2016/2/24.
 */
public class ClassDemo4 {
    public static void main(String[] args) {
        String s1 = "a";
        ClassUtil.printClassFiledMessage(s1);

        ClassUtil.printClassFiledMessage(new Integer(1));
    }
}
