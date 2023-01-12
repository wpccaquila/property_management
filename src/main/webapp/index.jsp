<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<h2>查询业主信息</h2>
<form action="${pageContext.request.contextPath}/sign_in">
    业主名字：<input type="text" name="owner_id"/><br/>
    <input type="submit" value="提交"/>
</form>

${requestScope.ownerInfo}

</body>
</html>