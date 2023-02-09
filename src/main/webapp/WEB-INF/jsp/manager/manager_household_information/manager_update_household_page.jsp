<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%-- 静态包含头部索引和标题信息--%>
    <%@ include file="../manager_public_part/manager_head.jsp"%>
</head>
    <style type="text/css">
        .register-form {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
<body
        style="background-image: url(images/background.jpg);
      background-size: cover;">

<%--<%= request.getParameter("household_birthday")  %>--%>
<%--<%= request.getParameterValues("household_birthday")  %>--%>

<div class="register-form">
    <div class="container" >
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">添加住户信息</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="<%=request.getContextPath()%>/updateHouseholdById?householdId=${householdInfoById.householdId}"  method="post" role="form">
                        <div class="form-group">
                            <label for="owner_name" class="col-sm-3 control-label">真实姓名：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="owner_name" name="owner_name"  value="${householdInfoById.ownerName}" placeholder="请输入真实姓名">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="household_id_number" class="col-sm-3 control-label">身份证号码：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="household_id_number" name="household_id_number"  value="${householdInfoById.householdIdNumber}" placeholder="请输入身份证号码">
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="household_birthday" class="col-sm-3 control-label">生日日期：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="household_birthday" name="household_birthday" value="${householdInfoById.householdBirthday}" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别：</label>
                            <div class="col-sm-9">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="household_gender" id="inlineRadio1" value="男"  <c:if test="${householdInfoById.householdGender == '男'}">checked</c:if>>
                                    <label class="form-check-label" for="inlineRadio1">男</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="household_gender" id="inlineRadio2" value="女" <c:if test="${householdInfoById.householdGender == '女'}">checked</c:if>>
                                    <label class="form-check-label" for="inlineRadio2">女</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="owner_phone" class="col-sm-3 control-label">手机号：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="owner_phone" name="owner_phone"value="${householdInfoById.ownerPhone}" placeholder="请输入手机号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="household_checkin_time" class="col-sm-3 control-label">入住时间：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="household_checkin_time" name="household_checkin_time" value="${householdInfoById.householdCheckinTime}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="household_house_type" class="col-sm-3 control-label">户型：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="household_house_type" name="household_house_type"  placeholder="户型" value="${householdInfoById.householdHouseType}">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">住址：</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="household_address_unit"   placeholder="第几幢" value="${household_address_unit}">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="household_address_building"   placeholder="第几单元" value="${household_address_building}">
                            </div>

                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="household_address_room"   placeholder="房间号" value="${household_address_room}" >
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit"   class="btn btn-lg btn-primary btn-block">修改住户信息</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <a href="<%=request.getContextPath()%>/forwardManagerHouseholdInformationPage" class="btn btn-lg btn-success btn-block">返回首页</a>
                            </div>
                        </div>
                    </form>

                        <script type="text/javascript">
                            $(function() {
                                $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
                                $("#household_birthday,#household_checkin_time").datepicker({
                                    dateFormat: "yy年mm月dd日",
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

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>