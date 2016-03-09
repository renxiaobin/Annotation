<%--
  Created by IntelliJ IDEA.
  User: rxb14
  Date: 2016/3/9
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Simple Captcha Servlet sample</h2>

<form action="submit.action" method="post">
  <img src="jcaptcha.jpg" /> <input type="text" name="jcaptcha" value="" />
  <input type="submit"/>
</form>
</body>
</html>
