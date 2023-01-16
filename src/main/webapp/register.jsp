<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>物业管理系统注册页面</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<style type="text/css">
    .register-form {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
</style>
<body
        style="background-image: url(images/background.jpg);
      background-size: cover;">
<div class="register-form">
    <div class="container" >
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">注册用户</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/register" method="post" role="form">
                        <div class="form-group">
                            <label for="realname" class="col-sm-3 control-label">真实姓名：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="realname" name="owner_name" placeholder="请输入真实姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-3 control-label">手机号：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="phone" name="owner_phone" placeholder="请输入手机号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">密码：</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="password" name="owner_password" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password2" class="col-sm-3 control-label">确认密码：</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="password2" name="confirm_password" placeholder="请再次输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-3 control-label">住址：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="address" name="owner_address" placeholder="请输入住址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="identity" class="col-sm-3 control-label">身份信息：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="identity" name="owner_identity" placeholder="请输入身份信息(业主/租客)">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-lg btn-primary btn-block">注册</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-lg btn-success btn-block">返回首页</a>
                            </div>
                        </div>
                    </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>