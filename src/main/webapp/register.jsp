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
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/register" onsubmit="return pwdCheck()" method="post" role="form">
                        <div class="form-group">
                            <label for="realname" class="col-sm-3 control-label">真实姓名：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="realname" name="owner_name" value="${requestScope.ownerInfo.owner_name}" placeholder="请输入真实姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-3 control-label">手机号：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="phone" name="owner_phone" value="${requestScope.ownerInfo.owner_phone}"placeholder="请输入手机号">
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
                                <input type="password" class="form-control" id="password2" name="confirm_password" onblur="pwdCheck()" placeholder="请再次输入密码">
                            </div>

<%--                            验证两次密码是否一致--%>
                            <p style="text-align:center" id="confirm_password_message"></p>

                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-3 control-label">住址：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="address" name="owner_address"   placeholder="请输入住址" value="${requestScope.ownerInfo.owner_address}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="identity" class="col-sm-3 control-label">身份信息：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="identity" name="owner_identity"  placeholder="请输入身份信息(业主/租客)" value="${requestScope.ownerInfo.owner_identity}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit"   class="btn btn-lg btn-primary btn-block">注册</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-lg btn-success btn-block">返回首页</a>
                            </div>
                        </div>
                    </form>

                        <%-- 当手机号重复时，提示--%>
                        <%
                            String msg = (String) request.getAttribute("SQLIntegrityConstraintViolationException");
                            if(msg != null){
                        %>
                        <script>
                            alert("警告提示：<%=msg%>");
                        </script>
                        <%
                            }
                        %>
                        <%-- 验证两次密码是否一致--%>
                        <script type="text/javascript">
                            function pwdCheck(){
                                var password1 = document.getElementById("password").value;
                                var password2 = document.getElementById("password2").value;
                                if(password1 != password2){
                                    document.getElementById('confirm_password_message').innerHTML = '<span style="color:red;">两次输入的密码不一致，请重新输入</span>';
                                    return false;
                                }else{
                                    document.getElementById('confirm_password_message').innerHTML = '<span style="color:green;">两次输入的密码一致</span>'
                                    return true;
                                }
                            }
                        </script>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>