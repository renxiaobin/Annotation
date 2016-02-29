package com.rxb.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的通信
 * 服务器端
 * Created by rxb14 on 2016/2/29.
 */
public class Server {
    public static void main(String[] args) {
        try {
            //创建服务器端socket，即ServerSocket
            ServerSocket server = new ServerSocket(8055);
            System.out.println("服务器启动，等待客户端接入");
            Socket socket = null;
            int count = 0;
            //循环监听
            while(true){
                //调用accept方法开始监听，等待客户端连接
                socket = server.accept();
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                //启动线程
                serverThread.start();
                count++;
                System.out.println("当前客户端数量为："+count);
                System.out.println("客户端地址为："+socket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
