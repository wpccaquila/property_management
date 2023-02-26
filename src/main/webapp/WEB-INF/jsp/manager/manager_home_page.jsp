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
        <div class="col-sm-2">
            <ul class="nav nav-pills nav-stacked">
                <%-- 静态包含左侧导航栏--%>
                <%@ include file="./manager_public_part/navigation_bar.jsp"%>
            </ul>
        </div>
        <div class="col-sm-10">
            <div class="panel panel-default">
                <div class="panel-heading">欢迎使用小区物业系统</div>
                <div class="panel-body">
                    <p>小区物业系统是一款专为小区物业管理而设计的软件，可以帮助小区物业管理更方便的管理小区，让每一位小区居民住的更放心。</p>
                </div>

                <div class="panel-heading">物业收费标准</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>户型</th>
                            <th>收费标准（元）/月</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>A型：一室一厅</td>
                            <td>800</td>
                        </tr>
                        <tr>
                            <td>B型：两室一厅</td>
                            <td>1200</td>
                        </tr>
                        <tr>
                            <td>C型：三室一厅</td>
                            <td>1600</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class="panel-heading">物业服务收费标准</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>物业服务</th>
                            <th>收费标准（元）/年</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>公共设施以及保养费</td>
                            <td>800</td>
                        </tr>
                        <tr>
                            <td>绿化管理费</td>
                            <td>200</td>
                        </tr>
                        <tr>
                            <td>清洁卫生费</td>
                            <td>600</td>
                        </tr>
                        <tr>
                            <td>保安费</td>
                            <td>500</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>
</body>

</html>