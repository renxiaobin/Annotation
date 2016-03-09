package com.rxb.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by rxb14 on 2016/3/8.
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取缓存中的验证码
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        //获取用户输入的验证码
        String inputCode = request.getParameter("inputCode");
        //转化为大写
        inputCode = inputCode.toUpperCase();
        //设置编码，获取输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(inputCode.equals(checkCode)){
            out.println("验证码输入正确！");
        }else{
            out.println("验证码输入错误！！");
        }
        out.flush();
        out.close();
    }
}
