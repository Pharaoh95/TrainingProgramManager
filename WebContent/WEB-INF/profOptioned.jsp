<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="profOptioneddgtb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 1px">
			<a href="#" id="profadd" class="easyui-linkbutton" iconCls="icon-add"
				plain="true">添加</a> 
			<a href="#" id="profdelete"
				class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除选中</a>
			<a href="#" id="mddelete" class="easyui-linkbutton" iconCls="icon-clear"
				plain="true">删除此模块</a>
			<a href="#" id="profsave" class="easyui-linkbutton"
			style="display:none;" iconCls="icon-save" plain="true">保存</a>
			<a href="#" id="profredo" class="easyui-linkbutton"
				style="display:none;" iconCls="icon-redo" plain="true">取消</a>
		</div>
	</div>
	<table id="profOptioneddg"></table>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/profOptioned.js"></script>
</body>
</html>