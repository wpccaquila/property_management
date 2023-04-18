<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2023/4/17
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>缴费页面</title>
    <meta charset="utf-8"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<body>
<div style="text-align:center;">
    <img src="images/jiaoFei.jpg" alt="图片" width="400" height="300" />
    <br />
    <button class="btn" onclick="goBack()">返回</button>
    <a class="btn" href="<%=request.getContextPath()%>/upDataPaymentState">已支付</a>
</div>

<script>
    function goBack() {
        window.history.back();
    }
</script>



</body>
</html>
