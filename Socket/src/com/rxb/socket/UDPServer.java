package com.rxb.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 基于UDP协议的socket通信
 * 服务器端
 * Created by rxb14 on 2016/2/29.
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器DatagramSocket，指定端口号
        DatagramSocket datagramSocket = new DatagramSocket(8066);
        //创建数据包，接收客户端发送的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        System.out.println("服务器启动，等待监听客户端");
        //阻塞监听，直至接收到客户端发送数据
        datagramSocket.receive(packet);
        //读取数据
        String info = new String(data,0,packet.getLength());
        System.out.println("接收到客户端发送的数据："+info);

        //向客户端发送响应信息
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "登录成功！".getBytes();
        //创建数据报
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        //向客户端发送数据
        datagramSocket.send(packet2);

        //关闭资源
        datagramSocket.close();
    }
}
