<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>物业管理系统登录页面</title>
    <meta charset="utf-8"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

    <style>
        .login {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>

</head>
<body
      style="background-image: url(images/background.jpg);
      background-size: cover;">
<div class="login">
    <div class="container" >
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">物业管理系统登录</h3>
                    </div>
                    <div class="panel-body">
                        <form accept-charset="UTF-8" role="form" action="<%=request.getContextPath()%>/owner_login">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="输入手机号" name="owner_phone" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="输入密码" name="owner_password" type="password" value="">
                                </div>
                                <div class="form-group">
                                    <select class="form-control" name="role">
                                        <option value="resident" name="resident_sign_in">住户</option>
                                        <option value="admin" name="manager_sign_in">管理员</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="登录">
                                </div>
                                <div class="form-group">
                                    <a href="<%=request.getContextPath()%>/register.jsp"><input class="btn btn-lg btn-success btn-block" type="button" value="注册"></a>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%-- 用户名或密码错误时，提示--%>
    <%
        String login_msg = (String)request.getAttribute("login_msg");
        if(login_msg != null) {
    %>
        <script>
            alert("用户名或密码错误");
        </script>
    <%
        }
    %>
</body>
</html>