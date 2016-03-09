<%@ page import="com.google.code.kaptcha.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: rxb14
  Date: 2016/3/9
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
  String kaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
  String inputCode = request.getParameter("r");
  if(kaptcha.equals(inputCode)){
    out.print("equal");
  }else{
    out.print("wrong");
  }
%>
</body>
</html>
