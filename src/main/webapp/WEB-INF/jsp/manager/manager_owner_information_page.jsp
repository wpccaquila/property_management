<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2023/1/18
  Time: 10:37
  用户信息管理页面
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
                <li class="active"><a href="manager_owner_information_page.jsp">用户信息管理</a></li>
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
                    <p>用户信息管理 <a style="float:right;" class="btn btn-primary" href="addUser.action">增加用户</a></p>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>用户名</th>
                                <th>用户地址</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${requestScope.users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.address}</td>
                                    <td>
                                        <a class="btn btn-primary" href="delUser.action?id=${user.id}">删除</a>
                                        <a class="btn btn-primary" href="updateUser.action?id=${user.id}">修改</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="text-center">
                        <ul class="pagination">
                            <li><a href="#">上一页</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">下一页</a></li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>