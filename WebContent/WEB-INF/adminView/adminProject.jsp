<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table id="dg"></table>
	<div id="tb" style="padding: 4px; height: auto">
		<div style="margin-bottom: 3px">
			<a onclick="drop()" href="#" class="easyui-linkbutton" plain="true"
				iconCls="icon-remove">删除选中</a> <a id="aprojsave"
				class="easyui-linkbutton" style="display: none;" iconCls="icon-save"
				plain="true">保存</a> <a id="aprojredo" class="easyui-linkbutton"
				style="display: none;" iconCls="icon-redo" plain="true">取消</a>
		</div>
		<div>
			<table>
				<tr>
					<td>课程查询:</td>
					<td><input id="esearchbox" name="searchInfo" /></td>
					<td width="5px;"></td>
					<td>导入课程:</td>
					<td><form
							action="${pageContext.request.contextPath}/adminController/importFile.html"
							id="imptForm" method="POST" enctype="multipart/form-data">
							<input id='imptProjs' name="projsFile" accept="application/vnd.ms-excel"/> 
							<a id='ensureImpt'
								class="easyui-linkbutton" style="display: none;" plain="true"
								iconCls="icon-ok">确认导入</a>
						</form></td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/adminView/adminProjects.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/lib/ajaxfileupload.js"></script>
</body>
</html>