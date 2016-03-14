<%--
  Created by IntelliJ IDEA.
  User: rxb14
  Date: 2016/3/13
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //给request,session,context分别属性删除
  request.removeAttribute("requestName");
  request.getSession().removeAttribute("sessionName");
  request.getServletContext().removeAttribute("contextName");

  //session中删除user对象，调用valueUnbound方法
  request.getSession().removeAttribute("currentUser");
%>
<html>
<head>
    <title></title>
</head>
<body>
销毁界面
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">创建</button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">销毁</button>
</body>
</html>
