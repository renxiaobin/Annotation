package com.rxb.ann;

/**
 * Created by rxb14 on 2016/2/25.
 */
@Description(desc="I am person")
public interface Person {
    @Description(desc="I am person method")
    @Deprecated
    public void sing();
    public void eat();
}
