
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>物业管理系统登录界面</title>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
            font-family: sans-serif;
        }
        .login-box {
            width: 600px;
            background: #fff;
            padding: 40px;
            margin: auto;
            margin-top: 80px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            border-radius: 5px;
            text-align: center;
            font-family: sans-serif;
        }
        .login-box h2 {
            margin-top: 0;
            margin-bottom: 10px;
            font-size: 24px;
            color: #333;
        }
        .login-box form {
            margin-top: 20px;
        }
        .login-box input[type="text"],
        .login-box input[type="password"] {
            border: none;
            width: 250px;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 10px;
            background-color: #e0e0e0;
            outline: none;
        }
        .login-box input[type="submit"] {
            width: 130px;
            padding: 10px;
            background-color: #4da4f4;
            border: none;
            border-radius: 5px;
            margin-right: 10px;
            outline: none;
            cursor: pointer;
            color: #fff;
            font-family: sans-serif;
            font-size: 16px;
        }
        .login-box a {
            width: 130px;
            padding: 10px;
            background-color: #4da4f4;
            border: none;
            border-radius: 5px;
            margin-right: 10px;
            outline: none;
            cursor: pointer;
            color: #fff;
            font-family: sans-serif;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>物业管理系统登录</h2>
    <form action="${pageContext.request.contextPath}/owner_login" method="post" onsubmit="return checkForm()">
        <input type="text" name="owner_phone" placeholder="手机号" autocomplete="off"/> <br>
        <input type="password" name="owner_password" placeholder="密码" autocomplete="off"/> <br>
        <input type="submit" value="登录" />
        <a href="${pageContext.request.contextPath}/register_forward" > 注册 </a>
    </form>
</div>
</body>
</html>