<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table id='adviceNormDg'></table>
	<div id='adviceNormDgTb' style="padding: 5px; height: auto">
		<a onclick="refreshTable($('#adviceNormDg'))" class="easyui-linkbutton" 
			plain="true" iconCls="icon-reload">刷新</a>
		<a href="#" id="adviceNormSave" class="easyui-linkbutton"
			style="display:none;" iconCls="icon-save" plain="true">保存</a>
		<a href="#" id="adviceNormRedo" class="easyui-linkbutton"
			style="display:none;" iconCls="icon-redo" plain="true">取消</a>
	</div>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/adminView/adviceSettings.js"></script>
</body>
</html>