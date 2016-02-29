package com.rxb.socket;

import java.io.*;
import java.net.Socket;

/**
 * 基于TCP协议的socket通信
 * 客户端
 * Created by rxb14 on 2016/2/29.
 */
public class Client {
    public static void main(String[] args) {
        try {
            //创建客户端Socket，指定服务器地址和端口号
            Socket socket = new Socket("localhost",8055);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：123，密码：abc");
            //刷新缓冲
            pw.flush();
            //关闭输出流
            socket.shutdownOutput();

            //接收服务器端响应信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while(data!=null){
                System.out.println("我是客户端,服务器发送的消息是："+data);
                data = br.readLine();
            }

            //关闭资源
            br.close();
            isr.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
