<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%@ include file="../manager_public_part/manager_head.jsp"%>
</head>
<body>
<%-- 静态包含顶部导航栏--%>
<%@ include file="../manager_public_part/manager_top.jsp"%>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">
            <ul class="nav nav-pills nav-stacked">
                <%-- 静态包含左侧导航栏--%>
                <%@ include file="../manager_public_part/navigation_bar.jsp"%>
            </ul>
        </div>
        <div class="col-sm-10">
            <div class="panel panel-default">
                <div class="panel-heading">住户缴费信息管理</div>
                <div class="panel-body">

                    <div class="panel-body">
                        <form  method="post" action="<%=request.getContextPath()%>/upDataBuildingInfo?buildingId=${buildingInfo.buildingId}">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>楼房</th>
                                    <th>单元</th>
                                    <th>房间</th>
                                    <th>住房人</th>
                                    <th>住房人电话</th>
                                </tr>
                                </thead>

                                <tbody>

                                <tr>
                                    <td>
                                        <input type="text" name="buildingNum" value="${buildingInfo.buildingNum}" class="form-control"/>
                                    </td>
                                    <td>
                                        <input type="text" name="unitNum" value="${buildingInfo.unitNum}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text" name="roomNum" value="${buildingInfo.roomNum}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text" name="ownerName" value="${buildingInfo.ownerName}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text"  name="ownerPhone" value="${buildingInfo.ownerPhone}" class="form-control" />
                                    </td>
                                    <td>
                                        <button type="submit" class="btn btn-primary">修改楼房信息</button>
                                    </td>

                                </tr>

                                </tbody>

                            </table>
                            <a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Building" class="btn btn-primary">返回</a>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</div>
</body>





</html>