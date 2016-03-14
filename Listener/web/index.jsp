<%--
  Created by IntelliJ IDEA.
  User: rxb14
  Date: 2016/3/11
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%=request.getSession().getAttribute("currentUser")%>
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">创建</button>
    <button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">销毁</button>
  </body>
</html>
