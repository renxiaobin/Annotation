package com.rxb.util;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * 为了对同一个测试方法同时进行对多组数据测试，可以使用参数设置
 * 1.更改默认的测试运行器为RunWith(Parameterized.class)
 * 2.声明变量来存放参数和预期结果值
 * 3.声明一个返回值为Collection的公共静态方法，并使用@Parameters进行修饰
 * 4.为测试类声明一个带有参数的公共构造函数，并在其中为之声明变量赋值
 * Created by rxb14 on 2016/3/18.
 */
@RunWith(Parameterized.class)
public class ParameterTest {
    int excepted = 0;
    int input1 = 0;
    int input2 = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{
                {3,1,2},
                {6,5,1}
        });
    }

    public ParameterTest(int excepted, int input1, int input2) {
        this.excepted = excepted;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd(){
        assertEquals(excepted,new Calculate().add(input1,input2));
    }
}
