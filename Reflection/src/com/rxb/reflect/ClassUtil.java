package com.rxb.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by rxb14 on 2016/2/24.
 */
public class ClassUtil {
    /**
     * 得到类的public方法信息
     * @param obj
     */
    public static void printClassMethodMessage(Object obj){
        Class c1 = obj.getClass();//传递的是什么类，获得的就是该类的类类型

        System.out.println("类名："+c1.getName());
        //获取该类下的所有public方法，包括从父类中继承的方法
        //getDeclaredMethods()获取的是该类下声明所有的方法，不论权限
        Method[] ms = c1.getMethods();
        for(int i=0;i<ms.length;i++){
            Class returnType = ms[i].getReturnType();//获取方法的返回类型的类类型
            String methodName =  ms[i].getName();//获取方法名
            Class[] paramsTypes = ms[i].getParameterTypes();//获取方法的参数列表的类类型
            System.out.println("方法返回类型："+returnType.getName());
            System.out.println("方法名："+methodName);
            System.out.print("参数列表：");
            for(int j=0;j<paramsTypes.length;j++){
                System.out.print(paramsTypes[j].getName()+",");
            }
            System.out.println();
        }
    }

    /**
     * 获取类声明的所有成员变量信息
     * @param obj
     */
    public static void printClassFiledMessage(Object obj){
        Class c2 = obj.getClass();
        //获取该类下所有的成员变量
        //getFields()方法获得的是public的成员变量
        Field[] fs = c2.getDeclaredFields();
        for(Field field : fs){
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            String fieldName = field.getName();

            System.out.println(typeName+" "+fieldName);
        }
    }

    /**
     * 获取类声明的所有构造函数的信息
     * @param obj
     */
    public static void printClassConMessage(Object obj){
        Class c3 = obj.getClass();
        //获取类的所有构造方法
        //构造方法的信息保存在Constructor对象中
        Constructor[] cs = c3.getDeclaredConstructors();
        for(Constructor constructor : cs){
            String conName = constructor.getName();
            Parameter[] parames = constructor.getParameters();
            System.out.print(conName+"(");
            for(Parameter parameter : parames){
                Class paraType = parameter.getType();
                String typeName = paraType.getName();
                String paraName = parameter.getName();
                System.out.print(typeName+" "+paraName+",");
            }
            System.out.println(")");
        }
    }
}