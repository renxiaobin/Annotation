package com.rxb.entity;

/**
 * Created by rxb14 on 2016/3/14.
 */
public class User {
    private String ip;
    private String sessionId;
    //首次访问的时间
    private String firstTime;

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
