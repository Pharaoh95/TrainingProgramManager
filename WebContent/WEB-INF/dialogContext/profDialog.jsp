<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div style="padding: 7px;margin-top: 7px;">
		<table>
			<tr>
				<td>课程名称：</td>
				<td><input id="addprofname" style="width: 149px;"/></td>
				<td width="20px"></td>
				<td>课程代码：</td>
				<td><input id="addprofpid" style="width: 120px;" class="easyui-validatebox" /></td>
			</tr>
		</table>
		</div>
		<div style="padding: 7px;">
			<table>
				<tr>
					<td>课程学分：</td>
					<td><input id="profscorepicker" /></td>
					<td width="72px"></td>
					<td>每周学时：</td>
					<td><input id="perwkhspicker" /></td>
				</tr>
			</table>
		</div>
		<div style="padding: 7px;">
			<table>
				<tr>
					<td>总 学 时：</td>
					<td><input id="profsumhspicker" /></td>
					<td width="72px"></td>
					<td>实践学时：</td>
					<td><input id="profprtchspicker" /></td>
				</tr>
			</table>
		</div>
		<div style="padding: 7px;">
			<table>
				<tr>
					<td>开课学期：</td>
					<td><input id="termspicker" /></td>
					<td width="72px"></td>
					<td>授课部门：</td>
					<td><input id="addprofdpt" style="width: 120px" class="easyui-validatebox" /></td>
				</tr>
			</table>
		</div>
		<div style="padding: 6px;text-align:right;margin-right:16px">
			<a href="#" id="porfdlgsave" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'" style="width: 65px">保存</a> 
		</div>
		<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/dlgCtx/profdialog.js"></script>
</body>
</html>