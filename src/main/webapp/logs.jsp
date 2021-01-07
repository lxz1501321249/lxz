<%--
  Created by IntelliJ IDEA.
  User: lxz_pc
  Date: 12/24/20
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${not empty sessionScope.email}">
    欢迎你${sessionScope.email}
    <br>
</c:if>
<a href="logs">查看历史记录</a>

<c:if test="${not empty requestScope.logs}">
    <table border="1">
        <tr>
            <td>Log ID</td>
            <td>Login Time</td>
        </tr>
        <c:forEach var="log" items="${logs}">
            <tr>
                <td>${log.log_id}</td>
                <td>${log.log_login_time}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
