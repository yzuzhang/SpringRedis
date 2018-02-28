<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@include file="../common/taglibs.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.getSession().setAttribute("ctx", path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表页面</title>
</head>
<body>

<table border="1">
	<tr>
		<td width="100">ID</td>
		<td width="100">昵称</td>
		<td width="100">操作</td>
	</tr>
	<c:if test="${not empty memberList}">
		<c:forEach items="${memberList}" var="member" >
		<tr>
			<td>${member.id}</td>
			<td>${member.nickname}</td>
			<td><a href="${ctx}/member/${member.id}/delete">删除</a></td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty memberList}">
		没有查询到数据
	</c:if>
</table><br>
<a href="${ctx}/member/add">添加</a>
</body>
</html>