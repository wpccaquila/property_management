<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2023/1/18
  Time: 10:37
  物业管理首页
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <%-- 静态包含头部索引和标题信息--%>
    <%@ include file="manager_public_part/manager_head.jsp"%>
</head>

<body>
    <%-- 静态包含顶部导航栏--%>
    <%@ include file="manager_public_part/manager_top.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="<%=request.getContextPath()%>/forward_manager_owner_information_page">用户信息管理</a></li>
                <li><a href="management_payment_information.jsp">物业缴费信息管理</a></li>
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