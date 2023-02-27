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
                    <%-- 查询用户--%>
                    <form action="<%=request.getContextPath()%>/selectPaymentByName" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">住户的姓名</span>
                            <input style="width:200px;" type="text" class="form-control" name="householdPaymentName"/>
                        </div>
                        <input style="float:left;margin-left:200px;width:95px;" type="submit" class="btn btn-primary" value="查询"/>
                    </form>

                    <input style="float:right;margin-right:15px;width:170px;" class="btn btn-primary" value="增加住户缴费信息" onclick="window.location.href='<%=request.getContextPath()%>/forwardInsertPayment'" />

                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 70px">缴费订单id</th>
                                    <th>住户手机号</th>
                                    <th style="width: 100px">住户姓名</th>
                                    <th style="width: 100px">缴费类型</th>
                                    <th>缴费金额</th>
                                    <th style="width: 100px">缴费方式</th>
                                    <th>缴费时间</th>
                                    <th style="width: 100px">缴费状态</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach items="${householdPaymentByPageList}" var="item" varStatus="status">
                                    <tr>
                                        <td>
                                                <%-- 是数据库中的行号，不是id号--%>
                                            <c:set var="householdPaymentStartLineNo" value="${householdPaymentStartLineNo + 1}" scope="request"/>
                                            <input type="text" readonly="readonly" name="householdPayment_id" value="${householdPaymentStartLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerPhone" value="${item.ownerPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerName" value="${item.ownerName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="paymentType" value="${item.paymentType}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="paymentAmount" value="${item.paymentAmount}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="paymentMethod" value="${item.paymentMethod}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="paymentTime" value="<fmt:formatDate value="${item.paymentTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="paymentStatus" value="${item.paymentStatus}" class="form-control" />
                                        </td>
                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpdateHouseholdPaymentPage?propertyPaymentId=${item.propertyPaymentId}&householdPaymentStartLineNo=${householdPaymentStartLineNo}"  class="btn btn-primary">修改数据</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deletePaymentInfoById?propertyPaymentId=${item.propertyPaymentId}')">删除用户</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </form>
                    </div>
                    </div>

                <%-- 页脚分页按钮--%>
                <div class="text-center">
                    <ul class="pagination">
                        <%-- 静态包含分页按钮--%>
                        <%@ include file="payment_paging_button.jsp"%>
                    </ul>
                </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>


<script type="text/javascript">
    //删除操作
    function deleteData(url){
        if(window.confirm("确定要删除吗？")){
            //执行删除操作
            window.location.href = url
        }
    }


</script>



</html>