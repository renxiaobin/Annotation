package com.rxb.socket;

import java.io.*;
import java.net.Socket;

/**
 * 服务器端线程类
 * Created by rxb14 on 2016/2/29.
 */
public class ServerThread extends Thread {
    Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while(data!=null){
                System.out.println("我是服务器，客户端发送的消息是："+data);
                data = br.readLine();
            }
            //关闭输入流
            socket.shutdownInput();

            //向客户端输出信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎登陆！");

            //关闭资源
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
