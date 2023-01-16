<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>小区物业系统</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">小区物业系统</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#">用户信息管理</a></li>
                <li><a href="#">住户信息管理</a></li>
                <li><a href="#">物业缴费信息管理</a></li>
                <li><a href="#">公告信息管理</a></li>
                <li><a href="#">维修信息管理</a></li>
                <li><a href="#">投诉信息管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-heading">欢迎使用小区物业系统</div>
                <div class="panel-body">
                    <p>小区物业系统是一款专为小区物业管理而设计的软件，可以帮助小区物业管理更方便的管理小区，让每一位小区居民住的更放心。</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>