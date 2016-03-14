package com.rxb.listener;

import com.rxb.entity.User;
import com.rxb.util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * 通过session监听器统计在线人数
 * Created by rxb14 on 2016/3/14.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private int userNum = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNum++;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNum",userNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNum--;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNum",userNum);

        ArrayList<User> userList = null;
        userList = (ArrayList<User>) httpSessionEvent.getSession().getServletContext().getAttribute("userList");
        if(null != SessionUtil.getUserBySessionId(userList,httpSessionEvent.getSession().getId())){
            userList.remove(SessionUtil.getUserBySessionId(userList,httpSessionEvent.getSession().getId()));
        }
    }
}
