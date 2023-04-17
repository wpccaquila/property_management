<%--
  Created by IntelliJ IDEA.
  User: wpcc
  Date: 2023/1/23
  Time: 9:51
  分页按钮
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 首页--%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=0">首页</a></li>
<%--如果当前页数是第一页时，第一页的按钮消失--%>
<% int buildingPageNo=(int)request.getAttribute("buildingPageNo");
    int buildingPages=(int)request.getAttribute("buildingPages");
    if(buildingPageNo==0){%>
<li><a style="display:none">上一页</a></li>
<%}else{%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=${buildingPageNo-1}">上一页</a></li>
<%}%>

<%--按钮的变化，当前页码大于第二页时。则中间按钮变为当前页--%>
<% if(buildingPageNo<2){%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=0">1</a></li>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=1">2</a></li>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=2">3</a></li>
<%}else if(buildingPageNo >= 2){%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=${buildingPageNo-1}">${buildingPageNo}</a></li>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=${buildingPageNo}">${buildingPageNo+1}</a></li>
<%-- 若是尾页时，最后一页不显示--%>
<%if(buildingPages-1 <= buildingPageNo){%>
<li><a style="display:none">${buildingPageNo+2}</a></li>
<%}else{%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=${buildingPageNo+1}">${buildingPageNo+2}</a></li>
<%}%>
<%}%>



<%--如果当前页数大于总页数，则下一页按钮消失--%>
<%if(buildingPages-1 <= buildingPageNo){%>
<li><a style="display:none">下一页</a></li>
<%}else{%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=${buildingPageNo+1}">下一页</a></li>
<%}%>
<%-- 尾页--%>
<li><a href="<%=request.getContextPath()%>/pageManagerBuildingInfoInformation?pageNo=${buildingPages-1}">尾页</a></li>