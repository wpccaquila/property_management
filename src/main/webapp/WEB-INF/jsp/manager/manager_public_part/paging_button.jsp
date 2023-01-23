<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2023/1/23
  Time: 9:51
  分页按钮
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 首页--%>
<li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=0">首页</a></li>
<%--如果当前页数是第一页时，第一页的按钮消失--%>
<% int pageNo=(int)request.getAttribute("ownerPageNo");
    int ownerPages=(int)request.getAttribute("ownerPages");
    if(pageNo==0){%>
    <li><a style="display:none">上一页</a></li>
<%}else{%>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=${ownerPageNo-1}">上一页</a></li>
<%}%>

<%--按钮的变化，当前页码大于第二页时。则中间按钮变为当前页--%>
<% if(pageNo<2){%>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=0">1</a></li>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=1">2</a></li>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=2">3</a></li>
<%}else{%>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=${ownerPageNo-2}">${ownerPageNo-1}</a></li>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=${ownerPageNo-1}">${ownerPageNo}</a></li>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=${ownerPageNo}">${ownerPageNo+1}</a></li>
<%}%>


<%
// 如果当前页数大于总页数，则下一页按钮消失
    if(ownerPages-1 <= pageNo){%>
    <li><a style="display:none">下一页</a></li>
<%}else{%>
    <li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=${ownerPageNo+1}">下一页</a></li>
<%}%>
<%-- 尾页--%>
<li><a href="<%=request.getContextPath()%>/page_manager_owner_information?pageNo=${ownerPages-1}">尾页</a></li>