<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>小区物业管理系统注册</title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            list-style: none;
            text-decoration: none;
        }
        body{

            background-size: cover;
            font-family: "微软雅黑";

        }
        .reg{
            width: 600px;
            height: 600px;
            background: rgba(255,255,255,0.8);
            border-radius: 8px;
            margin: 200px auto;
            padding: 10px;
            box-shadow: 0 0 8px #666;
        }
        .title{
            width: 100%;
            text-align: center;
            margin-top: 20px;
            font-size: 24px;
            font-weight: bold;
            color: #444;
            letter-spacing: 8px;
        }
        .reg_form{
            width: 100%;
            margin-top: 20px;
        }
        .reg_form ul{
            width: 100%;
            margin-top: 10px;
        }
        .reg_form ul li{
            width: 100%;
            height: 40px;
            line-height: 40px;
            margin-bottom: 8px;
            position: relative;
            font-size: 16px;
            color: #444;
        }
        .reg_form ul li label{
            width: 80px;
            height: 40px;
            line-height: 40px;
            display: block;
            float: left;
            text-align: center;
        }
        .reg_form ul li input{
            width: 280px;
            height: 40px;
            line-height: 40px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding-left: 8px;
            outline: none;
            display: block;
            float: left;
            font-size: 16px;
            margin-left: 10px;
        }
        .reg_form ul li input:focus{
            box-shadow: 0 0 1px #55acee;
            border-color: #55acee;
        }
        .reg_form ul li span{
            position: absolute;
            left: 380px;
            top: 8px;
            font-size: 14px;
            color: #ccc;
            cursor: pointer;
            display: none;
        }
        .reg_btn{
            width: 100%;
            height: 40px;
            line-height: 40px;
            text-align: center;
            margin-top: 20px;
            font-size: 16px;
            font-weight: bold;
            color: #fff;
            background: #55acee;
            border-radius: 5px;
            cursor: pointer;
            letter-spacing: 8px;
        }
    </style>
</head>
<body>
<div class="reg">
    <h3 class="title">小区物业管理系统注册</h3>
    <form class="reg_form" action="servlet/RegisterServlet" method="post" onsubmit="return checkForm()">
        <ul>
            <li><label>姓名：</label><input name="username" type="text" placeholder="请输入你的姓名" /></li>
            <li><label>手机号：</label><input name="telephone" type="text" placeholder="请输入11位手机号" /><span onclick="createCode()">发送验证码</span></li>
            <li><label>验证码：</label><input name="verifycode" type="text" placeholder="请输入收到的验证码" /></li>
            <li><label>邮箱：</label><input name="email" type="text" placeholder="请输入正确邮箱地址" /></li>
            <li><label>密码：</label><input name="password" type="password" placeholder="请输入6-18位密码" /></li>
            <li><label>确认密码：</label><input name="repass" type="password" placeholder="请确认密码" /></li>
        </ul>
        <h3 class="reg_btn" onclick="checkForm()">注册</h3>
    </form>
</div>
<script type="text/javascript">
    // 获取到表单
    var form = document.getElementsByClassName("reg_form")[0];
    // 获取到手机号输入框
    var telephone = form.telephone;
    // 获取到发送验证码按钮
    var sendBtn = form.getElementsByTagName("span")[0];
    // 获取到注册按钮
    var regBtn = document.getElementsByClassName("reg_btn")[0];
    // 校验表单
    function checkForm(){
        // 获取到当前表单中的所有input
        var inputs = form.getElementsByTagName("input");
        // 遍历input
        for (var i = 0; i < inputs.length; i++) {
            // 如果没有填写，则提示
            if (inputs[i].value == "") {
                alert("请输入完整信息！");
                return false;
            }
        }
        // 验证手机号码
        if (!/^1[34578]\d{9}$/.test(telephone.value)) {
            alert("请输入正确的手机号码！");
            return false;
        }
        // 验证邮箱
        if (!/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/.test(inputs[3].value)) {
            alert("请输入正确的邮箱地址！");
            return false;
        }
        // 验证密码
        if (!/^[0-9a-zA-Z_]{6,18}$/.test(inputs[4].value)) {
            alert("请输入正确的密码！");
            return false;
        }
        // 验证两次密码是否一致
        if (inputs[4].value != inputs[5].value) {
            alert("两次密码输入不一致！");
            return false;
        }
        // 验证验证码
        if (inputs[2].value != "1111") {
            alert("验证码输入错误！");
            return false;
        }
        return true;
    }
    // 点击发送验证码，模拟发送验证码
    function createCode(){
        alert("模拟发送验证码：1111");
    }
</script>
</body>
</html>