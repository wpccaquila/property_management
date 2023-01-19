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
                <%-- 静态包含左侧导航栏--%>
                <%@ include file="./manager_public_part/navigation_bar.jsp"%>
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