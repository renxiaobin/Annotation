<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rxb.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: rxb14
  Date: 2016/3/14
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
当前在线人数为：${userNum}<br>
  <%
    ArrayList<com.rxb.entity.User> userList = (ArrayList<User>) request.getServletContext().getAttribute("userList");
    if(userList != null){
      for (int i=0;i<userList.size();i++){
        User user = userList.get(i);
  %>
    IP:<%=user.getIp()%>,FirstTime:<%=user.getFirstTime()%>,SessionId:<%=user.getSessionId()%><br>
  <%
      }
    }
  %>
  </body>
</html>
