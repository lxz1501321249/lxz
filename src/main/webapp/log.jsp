<%--
  Created by IntelliJ IDEA.
  User: lxz_pc
  Date: 12/24/20
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<form action="log" method="post">
    邮箱<input name="email"/> <br>
    密码<input name="password" type="password" /> <br>
<%--    <input name="remember" type="checkbox" value="true"/>记住用户名和密码 <br>--%>
    <input type="submit" value="登录" /> <br>
</form>
</body>
</html>
