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
                <div class="panel-heading">住户缴费信息管理</div>
                <div class="panel-body">

                    <div class="panel-body">
                        <form  method="post" action="<%=request.getContextPath()%>/insertPaymentInfo">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>缴费订单id</th>
                                    <th>住户id</th>
                                    <th>住户姓名</th>
                                    <th>缴费金额</th>
                                    <th>缴费方式</th>
                                    <th>缴费时间</th>
                                    <th>缴费状态</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>
                                            <input type="text" readonly="readonly" name="householdPaymentStartLineNo"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="householdId" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="householdName"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  name="paymentAmount" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  name="paymentMethod"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  id="paymentTime" name="paymentTime"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text"  name="paymentStatus"  class="form-control" />
                                        </td>
                                        <td>
                                            <button type="submit" class="btn btn-primary">增加缴费信息</button>
                                            </td>
                                    </tr>
                                </tbody>

                            </table>
                        </form>
                    </div>
                    </div>

                <a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Payment" class="btn btn-primary">返回</a>

                </div>
            </div>
        </div>
    </div>
</div>
</body>


<script type="text/javascript">

    $(function() {
        $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        $("#paymentTime").datepicker({
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