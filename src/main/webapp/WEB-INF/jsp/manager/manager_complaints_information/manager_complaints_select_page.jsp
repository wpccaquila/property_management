<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <div class="panel-heading">住户投诉信息管理</div>
                <div class="panel-body">
                    <%-- 查询公告信息标题--%>
                    <form action="<%=request.getContextPath()%>/selectComplaintsInfoByName" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">投诉人姓名</span>
                            <input style="width:200px;" type="text" class="form-control" name="complaintName"/>
                        </div>
                        <input style="float:left;margin-left:200px;width:95px;" type="submit" class="btn btn-primary" value="查询"/>
                    </form>
                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>投诉信息id</th>
                                    <th>投诉时间</th>
                                    <th>投诉内容</th>
                                    <th>投诉人姓名</th>
                                    <th>投诉人电话</th>
                                    <th>投诉状态</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach items="${complaintsInfoByName}" var="item" varStatus="status">
                                    <tr>
                                        <td>
                                                <%-- 是数据库中的行号，不是id号--%>
                                            <c:set var="complaintsStartLineNo" value="${complaintsStartLineNo + 1}" scope="request"/>
                                            <input type="text" readonly="readonly" name="complaintsStartLineNo" value="${complaintsStartLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintTime" value="<fmt:formatDate value="${item.complaintTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintContent" value="${item.complaintContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintName" value="${item.complaintName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintPhone" value="${item.complaintPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintStatus" value="${item.complaintStatus}" class="form-control" />
                                        </td>

                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpdateComplaintsInfoById?complaintId=${item.complaintId}&complaintsStartLineNo=${complaintsStartLineNo}"  class="btn btn-primary">修改投诉</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteComplaintsInfoById?complaintId=${item.complaintId}')">删除投诉</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Complaints" class="btn btn-primary">返回</a>
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