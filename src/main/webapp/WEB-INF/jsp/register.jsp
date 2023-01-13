
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>业主注册</title>
    <style type="text/css">
        .title{
            text-align:center;
            font-size:20px;
            margin:20px 0 0 0;
        }
        .form{
            width:400px;
            margin:20px auto 0 auto;
            padding:20px;
            background-color:#F0F0F0;
            border:1px solid #CCC;
            border-radius:5px;
        }
        .form input{
            border: none;
            width: 350px;
            padding: 10px;
            display: block;
            margin: 0 auto;
            border-radius: 5px;
            background-color: #e0e0e0;
            outline: none;
        }
        .form button{
            width: 100%;
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
<div class="title">业主注册</div>
<div class="form">
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="owner_name" placeholder="请输入真实姓名" /> <br>
        <input type="text" name="owner_phone" placeholder="请输入手机号" /><br>
        <input type="password" name="owner_password" placeholder="请输入密码" /><br>
        <input type="password" name="confirm_password" placeholder="请再次输入密码" /><br>
        <input type="text" name="owner_address" placeholder="请输入住址" /><br>
        <input type="text" name="owner_identity" placeholder="请输入身份信息（业主/租客）" /><br>
        <button type="submit">提交</button>
    </form>

    <a href="${pageContext.request.contextPath}/index_forward">返回登录页面 </a>

</div>
</body>
</html>