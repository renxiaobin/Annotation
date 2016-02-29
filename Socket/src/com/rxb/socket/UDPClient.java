package com.rxb.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 基于UDP协议的socket通信
 * 客户端
 * Created by rxb14 on 2016/2/29.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //定义数据报地址、端口号以及发送的数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8066;
        byte[] data = "用户名：123，密码：abc".getBytes();
        //创建数据报
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //创建DatagramSocket
        DatagramSocket socket = new DatagramSocket();
        //向服务器发送数据
        socket.send(packet);

        //接收服务器响应数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
        //接收响应数据
        socket.receive(packet2);
        //读取数据
        String rep = new String(data2,0,packet2.getLength());
        System.out.println(rep);

        //关闭资源
        socket.close();
    }
}
