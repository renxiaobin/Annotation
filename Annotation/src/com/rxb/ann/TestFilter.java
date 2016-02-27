package com.rxb.ann;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by rxb14 on 2016/2/26.
 */

/**
 * 使用自定义注解获取查询sql语句
 */
public class TestFilter {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(1);
        query(f1);

        Filter f2 = new Filter();
        f2.setUserName("hello");
        query(f2);

        Filter f3 = new Filter();
        f3.setEmail("123@aaa.com,111@abc.com");
        query(f3);

        Filter2 f = new Filter2();
        f.setId(2);
        f.setName("sale");
        f.setAmount(100);
        query(f);
    }

    public static void query(Object filter){
        StringBuilder sb = new StringBuilder();

        //获取filter中的table信息
        Class c = filter.getClass();
        boolean isTExist = c.isAnnotationPresent(Table.class);
        if(isTExist){
            Table table = (Table) c.getAnnotation(Table.class);
            String tableName = table.value();
            sb.append("select * from "+tableName).append(" where 1=1");
        }

        //获取filter中待查字段的信息
        Field[] fs = c.getDeclaredFields();
        for(Field field : fs){
            boolean isCExist = field.isAnnotationPresent(Column.class);
            if(isCExist){
                Column column = field.getAnnotation(Column.class);
                String fieldName = field.getName();
                String columnName = column.value();
                //获取get方法名
                String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Object fieldValue = null;
                try {
                    //使用反射调用get方法，获取属性值
                    Method getMethod = c.getMethod(getMethodName);
                    fieldValue = getMethod.invoke(filter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //如果字段值为空，则不写入查询条件中
                if(fieldValue==null || (fieldValue instanceof Integer && Integer.parseInt(fieldValue.toString())==0)){
                    continue;
                }
                sb.append(" and ").append(columnName);
                //根据字段类型，拼接字符串
                if(fieldValue instanceof String){
                    //如果字符串值中包含逗号，则进行分割再使用in进行拼接
                    if(fieldValue.toString().contains(",")){
                        sb.append(" in(");
                        String[] ss = fieldValue.toString().split(",");
                        for(String s : ss){
                            sb.append("'"+s+"'"+",");
                        }
                        sb.deleteCharAt(sb.length()-1);
                        sb.append(")");
                    }else {
                        sb.append("="+"'" + fieldValue + "'");
                    }
                }else if(fieldValue instanceof Integer){
                    sb.append("="+fieldValue);
                }

            }
        }
        System.out.println(sb);
    }
}
