package com.rxb.entity;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * HttpSessionActivationListener用于实现session钝化以及活化时调用的方法，且必须实现Serializable接口
 * 当tomcat服务器关闭或重启时（亦或是修改web.xml等配置文件时），会将当前内存中的session保存到服务器的文件或者数据库中，这是钝化
 * 当tomcat启动时会将钝化的文件，重新生成session，这是活化
 * Created by rxb14 on 2016/3/13.
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("valueBound:"+httpSessionBindingEvent.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("valueUnbound:"+httpSessionBindingEvent.getName());
    }

    //钝化
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionWillPassivate:"+httpSessionEvent.getSource());
    }

    //活化
    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionDidActivate:"+httpSessionEvent.getSource());
    }
}
