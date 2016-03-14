<%--
  Created by IntelliJ IDEA.
  User: rxb14
  Date: 2016/3/13
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //给request,session,context分别添加属性
  request.setAttribute("requestName","requestValue");
  request.getSession().setAttribute("sessionName","sessionValue");
  request.getServletContext().setAttribute("contextName","contextValue");

  //session中保存user对象，调用valueBound方法
  request.getSession().setAttribute("currentUser", new com.rxb.entity.User());
%>
<html>
<head>
    <title></title>
</head>
<body>
创建界面
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">创建</button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">销毁</button>
</body>
</html>
