<%--
  Created by IntelliJ IDEA.
  User: winsion
  Date: 2017/3/17
  Time: 上午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'regist.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">

        function _change() {

            //重新执行 获取验证码
            var elc = document.getElementById("verifyCodeI");
            elc.src = "<c:url value="/VerifyCodeServlet"/>?xxx= "+new Date().getDate();
        }
        
    </script>
</head>
<body>
<h1>注册</h1>

<p style="color: red;font-weight: 900">${msg}</p>
<form action="<c:url value='/RegistServlet'/>" method="post">
<%--<form action="${pageContext.request.contextPath}/RegistServlet" method="post">--%>
    用户名: <input type="text" name="userName" value="${user.userName}"/>${errors.userName}<br/>
    密码吗: <input type="password" name="passWord" value="${user.passWord}"/>${errors.passWord}<br/>
    验证码: <input type="text" name="verifyCode" value="${user.verifyCode}" size="5">
           <img id="verifyCodeI" src="<c:url value='/VerifyCodeServlet'/> " border="1"/>
      <a href="javascript:_change()">换一张</a>${errors.verifyCode}<br/>
    <input type="submit" name="注册"/>
</form>
</body>
</html>
