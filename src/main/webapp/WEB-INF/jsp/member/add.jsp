<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.getSession().setAttribute("ctx", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>
</head>
<body>
	<form action="<%=basePath%>member/addMember" method="POST">
		ID：<input type="text" name="id" id="id" value=""/>
		昵称：<input type="text" name="nickname" id="nickname" value=""/>
		<input type="submit" value="提交"/>
	</form>
	<br>
	<a href="${ctx}member/list">返回</a>
</body>
</html>