package com.rxb.ann;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by rxb14 on 2016/2/25.
 */
public class ParseAnn {
    public static void main(String[] args) {
        try {
            //获取类上的注解
            Class c = Class.forName("com.rxb.ann.Child");
            Description cd = (Description) c.getAnnotation(Description.class);
            System.out.println(cd.desc());

            //获取方法上的注解
            Method[] ms = c.getMethods();
            for(Method m : ms){
                //判断方法上是否存在description注解
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if(isMExist){
                    Description md = (Description) m.getAnnotation(Description.class);
                    System.out.println(md.desc());
                }
            }

            //另一种方式获取方法上的注解
            for(Method m : ms){
                Annotation[] as = m.getAnnotations();
                for(Annotation a : as){
                    if(a instanceof Description){
                        Description d = (Description) a;
                        System.out.println(d.desc());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
