package com.rxb.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by rxb14 on 2016/3/2.
 */
public class TimerInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //执行Action之前获取时间
        long start = System.currentTimeMillis();
        //执行下一拦截器，若已经是最后一个拦截器，则执行目标Action
        String result = actionInvocation.invoke();
        //执行Action之后获取时间
        long end = System.currentTimeMillis();
        System.out.println("执行Action花费的时间："+(end-start)+"ms");
        return result;
    }
}
