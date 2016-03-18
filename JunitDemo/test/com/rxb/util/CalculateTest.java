package com.rxb.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 1.测试方法上必须使用@Test进行修饰
 * 2.测试方法必须使用public void 进行修饰，不能带任何的参数
 * 3.新建一个源代码目录来存放我们的测试代码
 * 4.测试类的包应该和被测试类保持一致
 * 5.测试单元中的每个方法必须可以独立测试，测试方法间不能有任何的依赖
 * 6.测试类使用Test作为类名的后缀（不是必须）
 * 7.测试方法使用test作为方法名的前缀（不是必须）
 * Created by rxb14 on 2016/3/17.
 */
public class CalculateTest {

    @Test
    public void testAdd() throws Exception {
        assertEquals(5,new Calculate().add(2,3));
    }

    @Test
    public void testSub() throws Exception {
        assertEquals(2,new Calculate().sub(6,4));
    }

    @Test
    public void testMultiple() throws Exception {
        assertEquals(6,new Calculate().multiple(2, 3));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(3,new Calculate().divide(6,2));
    }
}