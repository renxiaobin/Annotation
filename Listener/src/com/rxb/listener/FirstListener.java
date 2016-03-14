package com.rxb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext对象的监听器
 * 实现ServletContextListener接口
 * 该监听器主要用途是用作定时器或者加载一些全局属性对象
 * Created by rxb14 on 2016/3/11.
 */
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String initParam = servletContextEvent.getServletContext().getInitParameter("initParam");
        System.out.println("contextInitialized : initParam="+initParam);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
    }
}
