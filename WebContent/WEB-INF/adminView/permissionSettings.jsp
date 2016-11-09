<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table id="managerDg"></table>
	<div id="managerDgTb" style="padding: 7px; height: auto">
		<div>
			<table>
				<tr>
					<td>课程查询:</td>
					<td><input id="managerSb" name="searchInfo" /></td>
					<td><a id="mngerSave" class="easyui-linkbutton"
						style="display: none;" iconCls="icon-save" plain="true">保存</a></td>
					<td><a id="mngerRedo" class="easyui-linkbutton"
						style="display: none;" iconCls="icon-redo" plain="true">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/adminView/permissionSettings.js"></script>
</body>
</html>