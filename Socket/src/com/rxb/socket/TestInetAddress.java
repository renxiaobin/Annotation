package com.rxb.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by rxb14 on 2016/2/29.
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //获取本机InetAddress实例
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名："+inetAddress.getHostName());
            System.out.println("IP地址："+inetAddress.getHostAddress());
            System.out.println("字节数组形式的IP："+Arrays.toString(inetAddress.getAddress()));
            System.out.println(inetAddress);

            //根据名称获取InetAddress实例
            //InetAddress inetAddress2 = InetAddress.getByName("DESKTOP-H9DUGG0");
            InetAddress inetAddress2 = InetAddress.getByName("192.168.5.11");
            System.out.println("计算机名："+inetAddress2.getHostName());
            System.out.println("IP地址：" + inetAddress2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
