<%--
  Created by IntelliJ IDEA.
  User: winsion
  Date: 2017/3/17
  Time: 上午11:4afsadfas
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>登录</h1>

<p style="color: red;font-weight: 900">${msg}</p>
<form action="<c:url value='/LoginServlet'/>" method="post">
    <%--<form action="${pageContext.request.contextPath}/RegistServlet" method="post">--%>
    用户名: <input type="text" name="userName" value="${user.userName}"/><br/>
    密码吗: <input type="password" name="passWord" value="${user.passWord}"/><br/>
    <input type="submit" name="登录"/>
</form>
</body>


</html>
