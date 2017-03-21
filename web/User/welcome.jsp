<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: winsion
  Date: 2017/3/17
  Time: 上午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>My JSP 'regist.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<h1>登录成功</h1>
<c:choose>
    <c:when test="${empty sessionScope.sessionUser}" >cuo</c:when>
    <c:otherwise>${sessionScope.sessionUser}</c:otherwise>
</c:choose>
</body>
</html>
