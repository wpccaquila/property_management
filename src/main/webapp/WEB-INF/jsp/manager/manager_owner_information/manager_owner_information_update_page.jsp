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
                <div class="panel-heading">用户信息管理</div>
                    <div class="panel-body">
                        <form  action="<%=request.getContextPath()%>/update_manager_owner_information?owner_id=${ownerInfoById.owner_id}" method="post">
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
                                    <tr>
                                        <td>
                                            <input type="text" readonly="readonly" name="owner_id" value="${param.currentPageLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="owner_name" value="${ownerInfoById.owner_name}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="owner_phone" value="${ownerInfoById.owner_phone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="owner_address" value="${ownerInfoById.owner_address}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="owner_password" value="${ownerInfoById.owner_password}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="owner_identity" value="${ownerInfoById.owner_identity}" class="form-control" />
                                        </td>
                                        <td>
                                            <button type="submit" class="btn btn-primary">修改数据</button>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/delete_manager_owner_information?owner_id=${ownerInfoById.owner_id}')">删除用户</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <a href="<%=request.getContextPath()%>/PAGE-DEFAULT" class="btn btn-primary">返回</a>
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