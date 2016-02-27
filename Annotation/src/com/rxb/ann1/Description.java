package com.rxb.ann1;

import java.lang.annotation.*;

/**
 * Created by rxb14 on 2016/2/25.
 */
//元注解，用于注解注解的
//@Target定义注解作用域，TYPE表示类或接口，FIELD表示字段
//@Retention定义注解的生命周期，包括SOURCE,CLASS,RUNTIME
//@Inherited表示允许子类继承父类类上de 注解，但方法上的注解不会继承,实现接口的类不继承接口上的注解
//@Documented生产javadoc时包含该注解
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented

//定义了一个新的注解Description
//@interface声明了一个自定义的注解
//若注解中只有一个成员，则必须起名为value()（虽然编译器不会报错），使用时可以忽略成员名和赋值符号（=）
//注解可以没有任何成员，只用作标识
public @interface Description {
    //注解中的成员类型受限，只能包括基本数据类型，String，Class，Annotation，Enumeration
    //Map map();出错，不支持该类型
    String desc();

    //可以使用default定义默认值
    int age() default 18;
}
