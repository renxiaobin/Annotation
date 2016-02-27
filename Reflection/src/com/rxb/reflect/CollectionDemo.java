package com.rxb.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rxb14 on 2016/2/24.
 */
public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("hello");
        //泛型是为了防止输入错误，在编译时就确定的
        //list2.add(20);

        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        //c1==c2说明编译之后集合是去泛型化的
        System.out.println(c1 == c2);
        try {
            //可以通过方法的反射绕过编译
            Method m = c2.getMethod("add",Object.class);
            m.invoke(list2, 20);
            System.out.println(list2.size());

            //不能通过一般的foreach方法遍历集合元素，但是可以迭代遍历
            Iterator it = list2.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
