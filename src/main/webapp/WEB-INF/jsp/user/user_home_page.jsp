
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>物业管理系统</title>
  <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet" type="text/css">
  <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

</head>
<body>
<!-- 顶部导航栏 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">物业管理系统</a>
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

    <div class="col-sm-10">
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        物业通知
      </a>
      <div class="collapse" id="collapseExample">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th>公告标题</th>
              <th>公告内容</th>
              <th>发布时间</th>
              <th>发布人</th>
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
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample2" role="button" aria-expanded="false" aria-controls="collapseExample2">
        个人信息
      </a>
      <div class="collapse" id="collapseExample2">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th>姓名</th>
              <th>身份证号</th>
              <th>出生日期</th>
              <th>性别</th>
              <th>手机号</th>
              <th>入住时间</th>
              <th>户型</th>
              <th>地址</th>
            </tr>
            </thead>
            <tbody>
<%--            <c:forEach items="${householdInfoList}" var="item" varStatus="status">--%>
<%--              <tr>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_name" value="${item.householdName}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_phone" value="${item.householdIdNumber}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_address" value="${item.householdBirthday}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_password" value="${item.householdGender}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_identity" value="${item.householdPhone}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_identity" value="${item.householdCheckinTime}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_identity" value="${item.householdHouseType}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <input type="text" readonly="readonly" name="household_identity" value="${item.householdAddress}" class="form-control" />--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                  <a href="<%=request.getContextPath()%>/forwardUpdateHouseholdPage?householdId=${item.householdId}"  class="btn btn-primary">修改数据</a>--%>
<%--                  <a class="btn btn-primary"  href="javascript:deleteData('<%=request.getContextPath()%>/deleteHouseholdById?householdId=${item.householdId}')">删除用户</a>--%>
<%--                </td>--%>
<%--              </tr>--%>
<%--            </c:forEach>--%>
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
              <th scope="col">缴费项目</th>
              <th scope="col">金额</th>
              <th scope="col">时间</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>物业费</td>
              <td>500元</td>
              <td>2020-05-20</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample4" role="button" aria-expanded="false" aria-controls="collapseExample4">
        报修信息
      </a>
      <div class="collapse" id="collapseExample4">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th scope="col">报修内容</th>
              <th scope="col">时间</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>厕所堵塞</td>
              <td>2020-05-21</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
      <a class="btn btn-primary btn-block my-3" data-toggle="collapse" href="#collapseExample5" role="button" aria-expanded="false" aria-controls="collapseExample5">
        投诉信息
      </a>
      <div class="collapse" id="collapseExample5">
        <div class="card card-body">
          <table class="table">
            <thead>
            <tr>
              <th scope="col">投诉内容</th>
              <th scope="col">时间</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>物业服务态度不好</td>
              <td>2020-05-21</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>