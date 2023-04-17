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
                <div class="panel-heading">楼房信息管理</div>
                <div class="panel-body">
                    <%-- 查询楼房信息标题--%>
                        <form action="<%=request.getContextPath()%>/selectBuildingInfo" method="post" style="display: flex;">
                            <input style="width:50px;" type="text" class="form-control" name="buildingNum"/>
                            <p>幢</p>
                            <input style="width:50px;" type="text" class="form-control" name="unitNum"/>
                            <p>单元</p>
                            <input style="width:50px;" type="text" class="form-control" name="roomNum"/>
                            <p>房间</p>
                            <input style="margin-left: 10px; height: 34px;" type="submit" class="btn btn-primary" value="查询"/>
                        </form>

                    <input style="float:right;margin-right:15px;width:170px;" class="btn btn-primary" value="增加" onclick="window.location.href='<%=request.getContextPath()%>/forwardAddBuildingInfo'" />


                    <div class="panel-body">
                    <form  method="post">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 70px">id</th>
                                <th>楼房</th>
                                <th>单元</th>
                                <th>房间</th>
                                <th>住房人</th>
                                <th>住房人电话</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach items="${selectBuildingInfos}" var="item" varStatus="status">
                                <tr>
                                    <td>
                                            <%-- 是数据库中的行号，不是id号--%>
                                        <c:set var="buildingStartLineNo" value="${buildingStartLineNo + 1}" scope="request"/>
                                        <input type="text" readonly="readonly" name="complaintsStartLineNo" value="${buildingStartLineNo}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text" readonly="readonly" name="buildingNum" value="${item.buildingNum}" class="form-control"/>
                                    </td>
                                    <td>
                                        <input type="text" readonly="readonly" name="unitNum" value="${item.unitNum}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text" readonly="readonly" name="roomNum" value="${item.roomNum}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text" readonly="readonly" name="ownerName" value="${item.ownerName}" class="form-control" />
                                    </td>
                                    <td>
                                        <input type="text" readonly="readonly" name="ownerPhone" value="${item.ownerPhone}" class="form-control" />
                                    </td>

                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpDataBuildingInfo?buildingId=${item.buildingId}&buildingStartLineNo=${buildingStartLineNo}"  class="btn btn-primary">修改</a>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteBuildingInfoById?buildingId=${item.buildingId}')">删除</a>
                                        </td>
                                </tr>
                            </c:forEach>
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