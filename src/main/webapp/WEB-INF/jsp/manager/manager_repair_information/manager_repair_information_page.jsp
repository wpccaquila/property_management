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
                <div class="panel-heading">住户报修信息管理</div>
                <div class="panel-body">
                    <%-- 查询公告信息标题--%>
                    <form action="<%=request.getContextPath()%>/selectRepairByName" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">报修人姓名</span>
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
                                    <th style="width: 100px">报修类型</th>
                                    <th style="width: 250px">报修内容</th>
                                    <th style="width: 100px">报修时间</th>
                                    <th style="width: 100px">报修人</th>
                                    <th style="width: 120px">报修人电话</th>
                                    <th style="width: 100px">报修状态</th>
                                    <th style="width: 80px">维修人</th>
                                    <th style="width: 150px">维修内容</th>
                                    <th style="width: 100px">维修时间</th>
                                    <th style="width: 100px">用户评价</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach items="${repairInfoList}" var="item" varStatus="status">
                                    <tr>
                                        <td>
                                                <%-- 是数据库中的行号，不是id号--%>
                                            <c:set var="repairStartLineNo" value="${repairStartLineNo + 1}" scope="request"/>
                                            <input type="text" readonly="readonly" name="repairId" value="${repairStartLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairType" value="${item.repairType}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairContent" value="${item.repairContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairCreateTime" value="<fmt:formatDate value="${item.repairCreateTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerName" value="${item.ownerName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="ownerPhone" value="${item.ownerPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairState" value="${item.repairState}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairProcessor" value="${item.repairProcessor}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="processingContent" value="${item.processingContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairTime" value="<fmt:formatDate value="${item.repairTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="repairAppraise" value="${item.repairAppraise}" class="form-control" />
                                        </td>

                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpDataRepairInfoById?repairId=${item.repairId}&repairStartLineNo=${repairStartLineNo}"  class="btn btn-primary">修改报修</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteRepairInfoById?repairId=${item.repairId}')">删除报修</a>
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
                        <%@ include file="repair_paging_button.jsp"%>
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