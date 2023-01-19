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
                <div class="panel-heading">欢迎使用小区物业系统</div>
                <div class="panel-body">
                    <p>用户信息管理 </p>

                    <%-- 查询用户--%>
                    <form action="<%=request.getContextPath()%>/selectOwnerInfoByName" method="post">
                        <div class="input-group">
                            <span class="input-group-addon">用户的姓名</span>
                            <input type="text" class="form-control" name="ownerName"/>
                        </div>
                        <input type="submit" class="btn btn-primary" value="查询"/>
                    </form>

                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>id</th>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>地址</th>
                                    <th>密码</th>
                                    <th>身份信息</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ownerInfoByOwnerNameList}" var="item">
                                    <tr>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_id" value="${item.owner_id}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_name" value="${item.owner_name}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_phone" value="${item.owner_phone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_address" value="${item.owner_address}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_password" value="${item.owner_password}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_identity" value="${item.owner_identity}" class="form-control" />
                                        </td>
                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpdateOwner?ownerId=${item.owner_id}"  class="btn btn-primary">修改数据</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/delete_manager_owner_information?owner_id=${item.owner_id}')">删除用户</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                        <a href="<%=request.getContextPath()%>/page_manager_owner_information" class="btn btn-primary">返回</a>
                    </div>

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