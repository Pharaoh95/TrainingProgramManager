<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div align="center" style="padding: 7px; margin-top: 5px;">
		原密码：<input id='oringinalPwd' style="width: 149px;" type="password">
	</div>
	<div align="center" style="padding: 7px;">
		新密码：<input id='newPwd' style="width: 149px;" type="password">
	</div>
	<div align="center" style="padding: 7px;">
		&nbsp;Again：<input id='agnPwd' style="width: 149px;" type="password">
	</div>
	<div align="center" style="padding: 5px;">
		<a id='ensPwdSetting' class="easyui-linkbutton">确认修改</a>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/lib/jquery.md5.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/dlgCtx/pwdSettingsDlg.js"></script>
</body>
</html>