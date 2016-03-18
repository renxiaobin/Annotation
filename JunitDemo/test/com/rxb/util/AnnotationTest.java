package com.rxb.util;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Test:将一个方法修饰成测试方法
 * @Test(expected=xxx（异常类）.class)：若抛出该异常，测试通过
 * @Test(timeout=毫秒 )：设置执行的时间，用于结束死循环或是性能测试
 * @BeforeClass：所有方法之前执行，且执行一次 static修饰
 * @AfterClass：所有方法之后执行 static修饰
 * @Before：每一个测试方法之前执行
 * @After：每一个测试方法后执行
 * @Ignore:所修饰的测试方法会被测试运行器忽略
 * @RunWith:可以更改默认的测试运行器org.junit.runner.Runner
 * Created by rxb14 on 2016/3/17.
 */
public class AnnotationTest {

    @Test(expected = ArithmeticException.class)
    public void testDivide() throws Exception {
        assertEquals(3,new Calculate().divide(6,0));
    }

    @Ignore
    @Test(timeout = 2000)
    public void testWhile(){
        while (true){
            System.out.println("run forever");
        }
    }

    @Test(timeout = 3000)
    public void testThread(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}