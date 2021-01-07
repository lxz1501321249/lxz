<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <form action="login" method="post">
        用户名<input name="username" /> <br>
        密码<input name="password" type="password" /> <br>
        <input name="remember" type="checkbox" value="true"/>记住用户名和密码 <br>
        <input type="submit" value="登录" /> <br>
    </form>
</body>
</html>
