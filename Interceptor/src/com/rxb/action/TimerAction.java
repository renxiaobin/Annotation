package com.rxb.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by rxb14 on 2016/3/2.
 */
public class TimerAction extends ActionSupport {
    public String execute() throws Exception{
        for(int i=0;i<10000;i++){
            System.out.println("I love you!");
        }
        return SUCCESS;
    }
}
