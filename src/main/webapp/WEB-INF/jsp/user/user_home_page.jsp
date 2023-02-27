
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>物业管理系统</title>
  <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet" type="text/css">


  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

</head>
<body>
<!-- 顶部导航栏 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" >物业管理系统</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
      </li>
    </ul>

    <form class="form-inline my-2 my-lg-0" action="">
      <span class="navbar-text my-2 my-lg-0" >${currentOwnerInfo.owner_name}用户，欢迎你的登录</span>
      <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">退出<span class="sr-only">(current)</span></a>
    </form>
  </div>
</nav>

<div class="container">
  <div class="row justify-content-center">


    <div class="col-md-4">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block img-thumbnail " src="images/carousel1.jpg"  style="width:400px;height:400px;" alt="First slide">
          </div>
          <div class="carousel-item">
            <img class="d-block  img-thumbnail " src="images/carousel2.jpg"  style="width:400px;height:400px;" alt="Second slide">
          </div>
          <div class="carousel-item">
            <img class="d-block  img-thumbnail " src="images/carousel3.jpg"  style="width:400px;height:400px;" alt="Third slide">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
<%--    首页公告信息--%>
    <div class="col-md-6">
      <h3>${latestNotice.noticeTitle}</h3>
      <p>${latestNotice.noticeContent}</p>
      <p class="text-right">${latestNoticeDate}</p>
      <p class="text-right">${latestNotice.noticeCreateUser}</p>
    </div>

<%--   各类信息显示按钮--%>
    <div class="col-sm-12">
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        物业通知
      </a>
      <div class="collapse" id="collapseExample">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th style="width: 200px">公告标题</th>
              <th style="width: 350px">公告内容</th>
              <th style="width: 150px">发布时间</th>
              <th style="width: 150px">发布人</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${fourLatestNoticeList}" var="item" varStatus="status">
              <tr>
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
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>

      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample9" role="button" aria-expanded="false" aria-controls="collapseExample2">
        用户信息
      </a>
      <div class="collapse" id="collapseExample9">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th>姓名</th>
              <th>手机号</th>
              <th>密码</th>
              <th>身份信息</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>
                <input type="text" readonly="readonly" name="owner_name" value="${sessionScope.currentOwnerInfo.owner_name}" class="form-control" />
              </td>
              <td>
                <input type="text" readonly="readonly" name="owner_phone" value="${sessionScope.currentOwnerInfo.owner_phone}" class="form-control" />
              </td>
              <td>
                <input type="text" readonly="readonly" name="owner_password" value="${sessionScope.currentOwnerInfo.owner_password}" class="form-control" />
              </td>
              <td>
                <input type="text" readonly="readonly" name="owner_identity" value="${sessionScope.currentOwnerInfo.owner_identity}" class="form-control" />
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>


      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample2" role="button" aria-expanded="false" aria-controls="collapseExample2">
        个人信息
      </a>
      <div class="collapse" id="collapseExample2">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th style="width: 100px">姓名</th>
              <th style="width: 180px">身份证号</th>
              <th>出生日期</th>
              <th style="width: 70px">性别</th>
              <th>手机号</th>
              <th>入住时间</th>
              <th style="width: 60px">户型</th>
              <th style="width: 150px">地址</th>
            </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <input type="text" readonly="readonly" name="ownerName" value="${sessionScope.currentHouseholdInfo.ownerName}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="householdIdNumber" value="${sessionScope.currentHouseholdInfo.householdIdNumber}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="householdBirthday" value="${sessionScope.currentHouseholdInfo.householdBirthday}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="householdGender" value="${sessionScope.currentHouseholdInfo.householdGender}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="ownerPhone" value="${sessionScope.currentHouseholdInfo.ownerPhone}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="householdCheckinTime" value="${sessionScope.currentHouseholdInfo.householdCheckinTime}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="householdHouseType" value="${sessionScope.currentHouseholdInfo.householdHouseType}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="householdAddress" value="${sessionScope.currentHouseholdInfo.householdAddress}" class="form-control" />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample3" role="button" aria-expanded="false" aria-controls="collapseExample3">
        缴费信息
      </a>
      <div class="collapse" id="collapseExample3">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th>缴费类型</th>
              <th>缴费金额</th>
              <th>缴费方式</th>
              <th>缴费时间</th>
              <th>缴费状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.currentHouseholdPaymentInfoList}" var="item" varStatus="status">
              <tr>
                <td>
                  <input type="text" readonly="readonly" name="paymentType" value="${item.paymentType}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="paymentAmount" value="${item.paymentAmount}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="paymentMethod" value="${item.paymentMethod}" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="paymentTime" value="<fmt:formatDate value="${item.paymentTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                </td>
                <td>
                  <input type="text" readonly="readonly" name="paymentStatus" value="${item.paymentStatus}" class="form-control" />
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample4" role="button" aria-expanded="false" aria-controls="collapseExample4">
        报修信息
      </a>
      <div class="collapse" id="collapseExample4">
        <div class="card card-body">
        <%--  显示已报修的，并能提交用户评价--%>
           <table class="table">
             <thead>
              <tr>
                <th style="width: 150px">报修类型</th>
                <th style="width: 250px">报修内容</th>
                <th style="width: 150px">报修时间</th>
                <th style="width: 110px">状态</th>
                <th style="width: 90px">维修人</th>
                <th style="width: 150px">维修内容</th>
                <th style="width: 120px">维修时间</th>
                <th style="width: 120px">用户评价</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${sessionScope.currentRepairInfoList}" var="item" varStatus="status">
              <form  method="post" action="<%=request.getContextPath()%>/submitRepairAppraise?ownerPhone=${sessionScope.currentOwnerInfo.owner_phone}">
                <tr>
                    <input type="hidden" name="cuRepairId" value="${item.repairId}" />
                  <td>
                    <input type="text" readonly="readonly" name="repairType" value="${item.repairType}" class="form-control" />
                  </td>
                  <td>
                    <input type="text" readonly="readonly" name="repairContent" value="${item.repairContent}" class="form-control" />
                  </td>
                  <td>
                    <input type="text" readonly="readonly" name="repairCreateTime" value="<fmt:formatDate value="${item.repairCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" />" class="form-control" />
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
                    <input type="text" readonly="readonly" name="repairTime" value="<fmt:formatDate value="${item.repairTime}" pattern="yyyy-MM-dd HH:mm:ss" />" class="form-control" />
                  </td>
                  <td>
                    <input type="text"  name="repairAppraise" value="${item.repairAppraise}" class="form-control" />
                  </td>
                  <td>
                    <button style="width: 70px" type="submit" class="btn btn-primary">提交</button>
                  </td>
                </tr>
              </form>
              </c:forEach>
              </tbody>
            </table>

          <%-- 提交报修表单--%>
          <form  method="post" action="<%=request.getContextPath()%>/addRepairInfo?ownerName=${currentOwnerInfo.owner_name}&ownerPhone=${currentOwnerInfo.owner_phone}">
            <table class="table">
              <thead>
              <tr>
                <th style="width: 150px">报修类型</th>
                <th>报修内容</th>
              </tr>
              </thead>

              <tbody>
              <tr>
                <td>
                  <input type="text" name="repairType"  class="form-control" />
                </td>
                <td>
                  <input type="text" name="repairContent" class="form-control" />
                </td>
                <td>
                  <button type="submit" class="btn btn-primary">报修</button>
                </td>
              </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample5" role="button" aria-expanded="false" aria-controls="collapseExample5">
        投诉信息
      </a>
      <div class="collapse" id="collapseExample5">
        <div class="card card-body">
          <%--  显示已投诉的--%>
          <table class="table">
            <thead>
            <tr>
              <th style="width: 150px">投诉时间</th>
              <th style="width: 280px">投诉内容</th>
              <th style="width: 100px">投诉状态</th>
              <th style="width: 150px">处理内容</th>
              <th style="width: 150px">处理时间</th>
              <th style="width: 120px">用户反馈</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.currentComplaintsInfos}" var="item" varStatus="status">
            <form  method="post" action="<%=request.getContextPath()%>/submitComplaintAppraise?ownerPhone=${sessionScope.currentOwnerInfo.owner_phone}">
              <tr>
                <input type="hidden" name="cuComplaintId" value="${item.complaintId}" />
                  <td>
                    <input type="text" readonly="readonly" name="complaintTime" value="<fmt:formatDate value="${item.complaintTime}" pattern="yyyy-MM-dd" />" class="form-control" />
                  </td>
                  <td>
                    <input type="text" readonly="readonly" name="complaintContent" value="${item.complaintContent}" class="form-control" />
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
                    <input type="text"  name="userEvaluation" value="${item.userEvaluation}" class="form-control" />
                  </td>
                  <td>
                    <button style="width: 80px" type="submit"  class="btn btn-primary form-control">提交</button>
                  </td>
                </tr>

              </form>
            </c:forEach>
            </tbody>
          </table>
            <%-- 提交投诉表单--%>
            <form  method="post" action="<%=request.getContextPath()%>/addComplaintInfo?ownerName=${currentOwnerInfo.owner_name}&ownerPhone=${currentOwnerInfo.owner_phone}">
              <table class="table">
                <thead>
                <tr>
                  <th>投诉内容</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                  <td>
                    <input type="text" name="complaintContent"  class="form-control" />
                  </td>
                  <td>
                    <button type="submit" class="btn btn-primary">投诉</button>
                  </td>
                </tr>
                </tbody>
              </table>
            </form>

        </div>
      </div>
    </div>
  </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.slim.min.js"></script>
<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>


</body>
</html>