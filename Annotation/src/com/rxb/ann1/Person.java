package com.rxb.ann1;

/**
 * Created by rxb14 on 2016/2/25.
 */
@Description(desc="I am person")
public interface Person {
    @Description(desc="I am person method")
    @Deprecated
    void sing();
    void eat();
}
