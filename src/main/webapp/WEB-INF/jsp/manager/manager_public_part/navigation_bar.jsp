<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2023/1/19
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<li id="li1" onclick="changeActive('li1')" ><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Owner">用户信息管理</a></li>
<li id="li2" onclick="changeActive('li2')"><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Household">住户信息管理</a></li>
<li id="li3" onclick="changeActive('li3')"><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Building">楼房信息管理</a></li>
<li id="li4" onclick="changeActive('li4')"><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Payment">物业缴费信息管理</a></li>
<li id="li5" onclick="changeActive('li5')"><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Notice">公告信息管理</a></li>
<li id="li6" onclick="changeActive('li6')"><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Repair">维修信息管理</a></li>
<li id="li7" onclick="changeActive('li7')"><a href="<%=request.getContextPath()%>/PAGE-DEFAULT-Complaints">投诉信息管理</a></li>

<script type="text/javascript">

    // 鼠标点击后显示常亮
    function changeActive(id){
        var element = document.getElementById(id);
        element.className = 'active';
        setCookie("active_li", id, 1);
        // 遍历所有li，清除其他li中的class属性值
        var liElements = document.getElementsByTagName('li');
        for(var i = 0; i < liElements.length; i++){
            if(liElements[i].id !== id){
                liElements[i].className = '';
            }
        }
    }

        // 设置cookie
        function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays*24*60*60*1000));
        var expires = "expires="+ d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    }

        // 获取cookie
        function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
        c = c.substring(1);
    }
        if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
    }
    }
        return "";
    }

        // 获取cookie 中的li标签状态
        var activeLiId = getCookie("active_li");

        // 如果cookie中存在，则更新li标签状态
        if(activeLiId != "")
        {
            changeActive(activeLiId);
        }
</script>