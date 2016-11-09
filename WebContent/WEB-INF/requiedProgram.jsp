<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="requireddgtb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="#" id="batadd" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加指定课程</a>
			<a href="#" id="batdelete" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true">删除选中</a>
			<a href="#" id="reqsave" class="easyui-linkbutton"
				style="display:none;" iconCls="icon-save" plain="true">保存</a>
			<a href="#" id="reqredo" class="easyui-linkbutton"
				style="display:none;" iconCls="icon-redo" plain="true">取消</a>
			<a onclick="refreshTable($('#requireddg'))" href="#" class="easyui-linkbutton" 
				plain="true" iconCls="icon-reload">刷新</a>
		</div>
		<div>
			<table>
				<tr>
					<td>
						课程查询:
					</td>
					<td>
						<input id="requiredsb" name="searchInfo" />
					</td>
				</tr>
			</table>
		</div>
	</div>
	<table id="requireddg"></table>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/required.js"></script>
</body>
</html>