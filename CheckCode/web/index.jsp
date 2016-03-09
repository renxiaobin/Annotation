<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<html>
  <head>
    <title>验证码</title>
  </head>
  <script>
    function reloadCode(){
      var time = new Date().getTime();
      document.getElementById("imageCode").src = "<%=request.getContextPath()%>/servlet/CheckCodeServlet?d="+time;
    }
  </script>
  <body>
    <form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="get">
      验证码：<input type="text" name="inputCode" />
      <img id="imageCode" src="<%=request.getContextPath()%>/servlet/CheckCodeServlet" alt="验证码" >
      <a href="javascript:reloadCode();">看不清楚</a><br>
      <input type="submit" value="提交"/>
    </form>
  </body>
</html>
