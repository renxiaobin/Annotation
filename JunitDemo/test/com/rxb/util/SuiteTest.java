package com.rxb.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件就是组织许多测试类一起运行的，它需要做的就是
 * 1.先写一个作为测试套件的入口类，这个类里不包含任何其他的方法
 * 2.更改测试运行器为Suite.class
 * 3.将要测试的类作为数组传入Suite.SuiteClasses({})
 * Created by rxb14 on 2016/3/18.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TaskTest1.class,TaskTest2.class,TaskTest3.class})
public class SuiteTest {

}
