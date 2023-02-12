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
        <div class="col-sm-3">
            <ul class="nav nav-pills nav-stacked">
                <%-- 静态包含左侧导航栏--%>
                <%@ include file="../manager_public_part/navigation_bar.jsp"%>
            </ul>
        </div>
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-heading">住户信息管理</div>
                <div class="panel-body">
                    <%-- 查询用户--%>
                    <form action="<%=request.getContextPath()%>/householdInfoByName" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">用户的姓名</span>
                            <input style="width:200px;" type="text" class="form-control" name="ownerName"/>
                        </div>
                        <input style="float:left;margin-left:200px;width:95px;" type="submit" class="btn btn-primary" value="查询"/>
                    </form>
                    <input style="float:right;margin-right:15px;width:170px;" class="btn btn-primary" value="增加住户" onclick="window.location.href='<%=request.getContextPath()%>/forwardAddHouseholdInformationPage'" />

                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 70px">id</th>
                                    <th>姓名</th>
                                    <th>身份证号</th>
                                    <th>出生日期</th>
                                    <th style="width: 70px">性别</th>
                                    <th>手机号</th>
                                    <th>入住时间</th>
                                    <th style="width: 70px">户型</th>
                                    <th>地址</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach items="${householdInfoByName}" var="item" varStatus="status">
                                    <tr>
                                        <td>
                                                <%-- 为了美观设置的id号，不是数据库中的id号--%>
                                            <input type="text" readonly="readonly" name="household_id" value="<c:out value="${status.index + 1}"/>" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_name" value="${item.ownerName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_phone" value="${item.householdIdNumber}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="household_address" value="${item.householdBirthday}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="household_password" value="${item.householdGender}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="household_identity" value="${item.ownerPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="household_identity" value="${item.householdCheckinTime}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="household_identity" value="${item.householdHouseType}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="household_identity" value="${item.householdAddress}" class="form-control" />
                                        </td>
                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpdateHouseholdPage?householdId=${item.householdId}"  class="btn btn-primary">修改数据</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteHouseholdById?householdId=${item.householdId}')">删除用户</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Household" class="btn btn-primary">返回</a>
                        </form>
                    </div>
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