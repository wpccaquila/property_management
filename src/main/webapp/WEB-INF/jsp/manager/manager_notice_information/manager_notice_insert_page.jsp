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
                <div class="panel-heading">公告信息管理</div>
                <div class="panel-body">

                    <div class="panel-body">
                        <form  method="post" action="<%=request.getContextPath()%>/insertNotice">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>公告标题</th>
                                    <th style="width: 350px">公告内容</th>
                                    <th>发布时间</th>
                                    <th style="width: 120px">发布人</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>
                                            <input type="text" name="noticeTitle"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="noticeContent" class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="noticeCreateTime" id="noticeCreateTime"  class="form-control" />
                                        </td>
                                        <td>
                                            <input type="text" name="noticeCreateUser" class="form-control" />
                                        </td>
                                        <td>
                                            <button type="submit" class="btn btn-primary">发布公告</button>
                                        </td>
                                    </tr>
                                </tbody>

                            </table>
                        </form>
                    </div>
                    </div>

                <a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Notice" class="btn btn-primary">返回</a>

                </div>
            </div>
        </div>
    </div>
</div>
</body>


<script type="text/javascript">

    $(function() {
        $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        $("#noticeCreateTime").datepicker({
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