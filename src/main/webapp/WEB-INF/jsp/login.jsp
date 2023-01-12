<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2022/10/19
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登录</h2>
<form action="${pageContext.request.contextPath}/login">
    姓名：<input name="name">
    密码：<input type="password" name="pwd">
    <input type="submit" value="提交">
</form>
<br><br>
${msg}
</body>
</html>
