package com.rxb.listener;

import com.rxb.entity.User;
import com.rxb.util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 通过HttpServletRequest对象获取访问用户的信息（如IP地址等）
 * Created by rxb14 on 2016/3/14.
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    private ArrayList<User> userList;

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        userList = (ArrayList<User>) servletRequestEvent.getServletContext().getAttribute("userList");
        if(userList == null)
            userList = new ArrayList<User>();

        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionId = request.getSession().getId();
        if(SessionUtil.getUserBySessionId(userList,sessionId) == null){
            User user = new User();
            user.setSessionId(sessionId);
            user.setIp(request.getRemoteAddr());
            user.setFirstTime(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
            userList.add(user);
        }

        servletRequestEvent.getServletContext().setAttribute("userList",userList);
    }
}
