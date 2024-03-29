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
                <div class="panel-heading">输入公告信息标题</div>
                <div class="panel-body">
                    <%-- 查询公告信息标题--%>
                    <form action="<%=request.getContextPath()%>/selectNoticeByTitle" method="post">
                        <div  class="input-group text-center">
                            <span  class="input-group-addon">输入公告信息标题</span>
                            <input style="width:200px;" type="text" class="form-control" name="noticeTitle"/>
                        </div>
                        <input style="float:left;margin-left:200px;width:95px;" type="submit" class="btn btn-primary" value="查询"/>
                    </form>
                    <input style="float:right;margin-right:15px;width:170px;" class="btn btn-primary" value="发布公告" onclick="window.location.href='<%=request.getContextPath()%>/forwardInsertNoticePage'" />

                    <div class="panel-body">
                        <form  method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 70px">id</th>
                                    <th>公告标题</th>
                                    <th style="width: 350px">公告内容</th>
                                    <th>发布时间</th>
                                    <th style="width: 120px">发布人</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach items="${selectNoticeInfoByNameList}" var="item" varStatus="status">
                                    <tr>
                                        <td>
                                                <%-- 是数据库中的行号，不是id号--%>
                                            <c:set var="noticeStartLineNo" value="${noticeStartLineNo + 1}" scope="request"/>
                                            <input type="text" readonly="readonly" name="noticeId" value="${noticeStartLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="noticeTitle" value="${item.noticeTitle}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="noticeContent" value="${item.noticeContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="noticeCreateTime" value="<fmt:formatDate value="${item.noticeCreateTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="noticeCreateUser" value="${item.noticeCreateUser}" class="form-control" />
                                        </td>
                                        <td>
                                            <a href="<%=request.getContextPath()%>/forwardUpDataNoticeInfoPage?noticeId=${item.noticeId}&noticeStartLineNo=${noticeStartLineNo}"  class="btn btn-primary">修改公告</a>
                                            <br>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteNoticeInfoById?noticeId=${item.noticeId}')">删除公告</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Notice" class="btn btn-primary">返回</a>
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