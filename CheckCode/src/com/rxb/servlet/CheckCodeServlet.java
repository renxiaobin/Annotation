package com.rxb.servlet;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by rxb14 on 2016/3/8.
 */
public class CheckCodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //使用BufferedImage对象生成验证码图片
        BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
        //获取画笔，并设置画笔颜色
        Graphics g = bi.getGraphics();
        Color c = new Color(200,150,255);
        g.setColor(c);
        //绘制填充矩形
        g.fillRect(0,0,68,22);

        //声明验证码包含的字符数组
        char[] codes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new Random();
        int len = codes.length;
        int index;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<4;i++){
            //随机获取验证码字符
            index = random.nextInt(len);
            //随机设置验证码字符颜色
            g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
            //绘制当前验证码字符
            g.drawString(codes[index] + "", (i * 15) + 3, 18);
            sb.append(codes[index]);
        }
        //保存验证码至session缓存中，以便与用户的输入进行对比
        request.getSession().setAttribute("checkCode",sb.toString());
        //将生成的验证码图片写入响应的输出流
        ImageIO.write(bi,"JPG",response.getOutputStream());
    }
}
