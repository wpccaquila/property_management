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
                <div class="panel-heading">住户投诉信息管理</div>
                <div class="panel-body">

                    <div class="panel-body">
                        <form  method="post" action="<%=request.getContextPath()%>/updateComplaintsInfoById?complaintId=${complaintsInfoById.complaintId}">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 70px">id</th>
                                    <th style="width: 120px">投诉时间</th>
                                    <th style="width: 350px">投诉内容</th>
                                    <th style="width: 100px">投诉人姓名</th>
                                    <th>投诉人电话</th>
                                    <th style="width: 100px">投诉状态</th>
                                    <th style="width: 150px">处理内容</th>
                                    <th>处理时间</th>
                                    <th>用户反馈</th>
                                </tr>
                                </thead>

                                <tbody>

                                    <tr>
                                        <td>
                                            <input type="text" readonly="readonly" name="complaintsStartLineNo" value="${param.complaintsStartLineNo}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" id="complaintTime" name="complaintTime" value="<fmt:formatDate value="${complaintsInfoById.complaintTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  name="complaintContent" value="${complaintsInfoById.complaintContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  name="ownerName" value="${complaintsInfoById.ownerName}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"   name="ownerPhone" value="${complaintsInfoById.ownerPhone}" class="form-control" />
                                        </td>
                                        <td>
                                            <div class="form-check form-check-inline ">
                                                <input class="form-check-input" type="radio" name="complaintStatus" id="inlineRadio1" value="未处理"  <c:if test="${complaintsInfoById.complaintStatus == '未处理'}">checked</c:if>>
                                                <label class="form-check-label" for="inlineRadio1">未处理</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="complaintStatus" id="inlineRadio3" value="处理中" <c:if test="${complaintsInfoById.complaintStatus == '处理中'}">checked</c:if>>
                                                <label class="form-check-label" for="inlineRadio2">处理中</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="complaintStatus" id="inlineRadio2" value="已处理" <c:if test="${complaintsInfoById.complaintStatus == '已处理'}">checked</c:if>>
                                                <label class="form-check-label" for="inlineRadio2">已处理</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" name="processingContent" value="${complaintsInfoById.processingContent}" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="processingDate" id="processingDate"value="<fmt:formatDate value="${complaintsInfoById.processingDate}" pattern="yyyy-MM-dd" />" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" readonly="readonly" name="userEvaluation" value="${complaintsInfoById.userEvaluation}" class="form-control" />
                                        </td>
                                        <td>
                                            <button type="submit" class="btn btn-primary">修改数据</button>
                                            <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteComplaintsInfoById?complaintId=${complaintsInfoById.complaintId}')">删除投诉</a>
                                        </td>

                                    </tr>
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


    $(function() {
        $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        $("#complaintTime,#processingDate").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true,
        yearRange: '1950:2025',
        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesShort: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六']
        });
    });



</script>



</html>