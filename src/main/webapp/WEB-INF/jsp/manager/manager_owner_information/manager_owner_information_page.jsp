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
                <div class="panel-heading">用户信息管理</div>
                <div class="panel-body">
                    <%-- 查询用户--%>
                    <form action="<%=request.getContextPath()%>/selectOwnerInfoByName" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">用户的姓名</span>
                            <input style="width:200px;" type="text" class="form-control" name="ownerName"/>
                        </div>
                        <input style="float:left;margin-left:200px;width:95px;" type="submit" class="btn btn-primary" value="查询"/>
                    </form>

                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>id</th>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>密码</th>
                                    <th>身份信息</th>
                                </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${ownerInfoList}" var="item" varStatus="status">
                                        <tr>
                                            <td>
                                                    <%-- 是数据库中的行号，不是id号--%>
                                                <c:set var="ownerStartLineNo" value="${ownerStartLineNo + 1}" scope="request"/>
                                                <input type="text" readonly="readonly" name="owner_id" value="${ownerStartLineNo}" class="form-control" />
                                            </td>
                                            <td>
                                                <input type="text" readonly="readonly" name="owner_name" value="${item.owner_name}" class="form-control" />
                                            </td>
                                            <td>
                                                <input type="text" readonly="readonly" name="owner_phone" value="${item.owner_phone}" class="form-control" />
                                            </td>
                                            <td>
                                                <input type="text" readonly="readonly" name="owner_password" value="${item.owner_password}" class="form-control" />
                                            </td>
                                            <td>
                                                <input type="text" readonly="readonly" name="owner_identity" value="${item.owner_identity}" class="form-control" />
                                            </td>
                                            <td>
                                                <a  href="<%=request.getContextPath()%>/forwardUpdateOwner?ownerId=${item.owner_id}&ownerStartLineNo=${ownerStartLineNo}"  class="btn btn-primary">修改数据</a>
                                                <br>
                                                <a  class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/delete_manager_owner_information?ownerId=${item.owner_id}')">删除用户</a>
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
                            <%@ include file="owner_paging_button.jsp"%>
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