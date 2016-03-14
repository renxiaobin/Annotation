package com.rxb.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ServletRequest对象的监听器
 * 实现ServletRequestListener接口
 * 一般用于读取参数和记录访问历史
 * Created by rxb14 on 2016/3/11.
 */
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        String name = servletRequestEvent.getServletRequest().getParameter("name");
        System.out.println("requestInitialized : name="+name);
    }
}
