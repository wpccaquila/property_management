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
        <div class="col-sm-2">
            <ul class="nav nav-pills nav-stacked">
                <%-- 静态包含左侧导航栏--%>
                <%@ include file="../manager_public_part/navigation_bar.jsp"%>
            </ul>
        </div>
        <div class="col-sm-10">
            <div class="panel panel-default">
                <div class="panel-heading">住户投诉信息管理</div>
                <div class="panel-body">
                    <%-- 查询公告信息标题--%>
                    <form action="<%=request.getContextPath()%>/selectComplaintsInfoByName" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">投诉人姓名</span>
                            <input style="width:200px;" type="text" class="form-control" name="ownerName"/>
                        </div>
                        <input style="float:left;margin-left:200px;width:95px;" type="submit" class="btn btn-primary" value="查询"/>
                    </form>
                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 70px">id</th>
                                    <th style="width: 120px">投诉时间</th>
                                    <th style="width: 280px">投诉内容</th>
                                    <th style="width: 100px">投诉人姓名</th>
                                    <th>投诉人电话</th>
                                    <th style="width: 100px">投诉状态</th>
                                    <th style="width: 150px">处理内容</th>
                                    <th>处理时间</th>
                                    <th>用户反馈</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach items="${complaintsInfoList}" var="item" varStatus="status">
                                    <tr>
                                        <td>
                                                <%-- 是数据库中的行号，不是id号--%>
                                            <c:set var="complaintsStartLineNo" value="${complaintsStartLineNo + 1}" scope="request"/>
                                            <input type="text" readonly="readonly" name="complaintsStartLineNo" value="${complaintsStartLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintTime" value="<fmt:formatDate value="${item.complaintTime}" pattern="yyyy-MM-dd HH:mm:ss" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintContent" value="${item.complaintContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerName" value="${item.ownerName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerPhone" value="${item.ownerPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintStatus" value="${item.complaintStatus}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="processingContent" value="${item.processingContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" id="processingDate" name="processingDate" value="<fmt:formatDate value="${item.processingDate}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="userEvaluation" value="${item.userEvaluation}" class="form-control" />
                                        </td>

                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpdateComplaintsInfoById?complaintId=${item.complaintId}&complaintsStartLineNo=${complaintsStartLineNo}"  class="btn btn-primary">修改投诉</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteComplaintsInfoById?complaintId=${item.complaintId}')">删除投诉</a>
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
                        <%@ include file="complaints_paging_button.jsp"%>
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