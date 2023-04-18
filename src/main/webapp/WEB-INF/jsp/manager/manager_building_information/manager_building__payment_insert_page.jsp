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
                <div class="panel-heading">发起缴费信息</div>
                <div class="panel-body">

                    <div class="panel-body">
                        <form  method="post" action="<%=request.getContextPath()%>/BuildingInsertPayment">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>楼房</th>
                                    <th>单元</th>
                                    <th>房间</th>
                                    <th>户型</th>
                                    <th>住户姓名</th>
                                    <th>住户手机号</th>
                                    <th>缴费类型</th>
                                    <th>缴费金额</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>
                                            <input type="text" readonly="readonly" name="buildingNum" value="${buildingPaymentInfo.buildingNum}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="unitNum" value="${buildingPaymentInfo.unitNum}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="roomNum"  value="${buildingPaymentInfo.roomNum}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="householdHouseType" value="${buildingPaymentInfo.householdHouseType}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerName" value="${buildingPaymentInfo.ownerName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerPhone" value="${buildingPaymentInfo.ownerPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"name="paymentType"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  name="paymentAmount" class="form-control" />
                                        </td>
                                        <td>
                                            <button type="submit" class="btn btn-primary">增加缴费信息</button>
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