<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">这是一个华丽丽的欢迎界面</h1>
	<h2>&nbsp;&nbsp;用户编号：${Manager.id}</h2>
	<h2>&nbsp;&nbsp;用户名称：${Manager.name}</h2>
	<h2>&nbsp;&nbsp;权限等级：${Manager.level}/5</h2>
	<h2>&nbsp;&nbsp;维护专业：${Manager.maintainMajor.name}</h2>
	<c:if test="${Manager.maintainMajor.level}">
		<h2>&nbsp;&nbsp;专业层次：本科</h2>
	</c:if>
	<c:if test="${!Manager.maintainMajor.level}">
		<h2>&nbsp;&nbsp;专业层次：专科</h2>
	</c:if>

	<h2>&nbsp;&nbsp;专业类别：${Manager.maintainMajor.type}</h2>

</body>
</html>