package com.octo.captcha.module.servlet.image;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SubmitActionServlet extends HttpServlet {
    public SubmitActionServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCaptchaResponse = request.getParameter("jcaptcha");
        boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        if(captchaPassed) {
            response.getWriter().write("captcha passed");
        } else {
            response.getWriter().write("captcha failed");
        }

        response.getWriter().write("<br/><a href=\'index.jsp\'>再试一次</a>");
    }
}
