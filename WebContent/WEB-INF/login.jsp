<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="img/bee_favicon.ico" type="image/x-icon" />
<title>系统登录页面</title>
</head>
<body background="/TrainingProgramManager/img/back.jpg">
	<div class="text" style="text-align: center;">
		<h1>九江学院培养方案管理系统</h1>
	</div>

	<div id="login">
		<p>
			管理员帐号：<input type="text" value="pharaoh" id="username" class="textbox">
		</p>
		<p>
			管理员密码：<input type="password" value="123123" id="password" class="textbox">
		</p>
		<table align="center">
			<tr>
				<td><input id="tradio" type="radio" checked="checked"
					name="character" value="teacher"></td>
				<td><label style="text-align: center;" for="tradio">教师用户</label></td>
				<td><input id="aradio" type="radio" name="character"
					value="admin"></td>
				<td><label for="aradio" style="text-align: center;">管理员</label></td>
			</tr>
		</table>
		<div id="bb" style="height: 28px" >
			<a id="alodin" class="easyui-linkbutton">登录</a> 
			<a id="aclear" class="easyui-linkbutton">清空</a>
		</div>
	</div>
	<!-- 这样是直接加载所有easyui的库，可用只能加载代替-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/login.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/lib/jquery.md5.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/css/login.css" />
</body>

</html>