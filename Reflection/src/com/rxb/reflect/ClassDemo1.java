package com.rxb.reflect;

/**
 * Created by rxb14 on 2016/2/23.
 */
public class ClassDemo1 {

    public static void main(String[] args) {
        //A���ʵ������
        A a1 = new A();//al��A���ʵ������

        //A����ʵҲ��һ�����ʵ��������������Class
        //�κ�һ���඼��Class��ʵ���������������ֱ�ʾ��ʽ
        //c1��c2��ʾ��A��������ͣ�class type��

        //��һ�ֱ�﷽ʽ��Ҳ�������κ�һ���඼��һ�������ľ�̬��Ա����class
        Class c1 = A.class;

        //�ڶ��ֱ�﷽ʽ����֪A���ʵ������ͨ��getClass�������
        Class c2 = a1.getClass();

        //��ȣ���Ϊһ����ֻ������Class���һ��ʵ������
        System.out.println(c1 == c2);

        //�����ֱ�﷽ʽ
        Class c3 = null;
        try {
            c3 = Class.forName("com.rxb.reflect.A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c3 == c2);

        //ͨ��һ����������Ϳ��Դ��������ʵ�����󣬼�ͨ��c1��c2ȥ����A���ʵ������
        try {
            A a2 = (A)c1.newInstance();//������Ҫ�������޲����Ĺ��췽��
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