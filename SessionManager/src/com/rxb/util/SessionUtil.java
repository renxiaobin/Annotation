package com.rxb.util;

import com.rxb.entity.User;

import java.util.ArrayList;

/**
 * Created by rxb14 on 2016/3/14.
 */
public class SessionUtil {
    public static Object getUserBySessionId(ArrayList<User> userList,String sessionId){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getSessionId().equals(sessionId)){
                return userList.get(i);
            }
        }
        return null;
    }
}
