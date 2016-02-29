package com.rxb.socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rxb14 on 2016/2/29.
 */
public class TestURL1 {
    public static void main(String[] args) {
        try {
            URL baidu = new URL("http://www.baidu.com");
            //?后表示参数，#后表示锚点
            URL url = new URL(baidu,"/index.html?q=123#test");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机："+url.getHost());
            //如果未指定端口号，则根据协议不同使用默认的端口号。此时getPort()方法返回-1
            System.out.println("端口：" + url.getPort());
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("相对路径：" + url.getRef());//即#号后的锚点信息
            System.out.println("查询字符串："+url.getQuery());//?号后的参数信息
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
