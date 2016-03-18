package com.rxb.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 1.Failure 一般由单元测试使用的方法判断失败所引起的，这表示测试点发现了问题，就是说问题输出的结果和我们预期的不一样。
 * 2.Error是有代码异常引起的，它可以产生于测试代码本身的错误，也可以是测试代码中一个隐藏的bug
 * 3.测试用例不是用来证明你是对的，而是用来证明你没有错（逻辑上没有错）。
 * Created by rxb14 on 2016/3/17.
 */
public class ErrorAndFailureTest {

    @Test
    public void testAdd() throws Exception {
        assertEquals(5,new Calculate().add(2,4));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(3,new Calculate().divide(6,0));
    }
}