package com.rxb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rxb14 on 2016/2/29.
 */
public class TestURL2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            //通过URL的openStream方法获取字节输入流
            InputStream is = url.openStream();
            //将字节输入流转化为字符输入流
            InputStreamReader isr = new InputStreamReader(is);
            //添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data!=null){
                System.out.println(data);
                data = br.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
