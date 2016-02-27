package com.rxb.ann1;

/**
 * Created by rxb14 on 2016/2/25.
 */
@Description(desc="I am child")
public class Child implements Person {
    @Description(desc="I am child method",age=20)
    @Override
    public void sing() {

    }

    @Override
    public void eat() {

    }
}
