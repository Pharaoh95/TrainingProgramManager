<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="padding: 7px;margin-top: 5px">
		<table>
			<tr>
				<td>课程学分：</td>
				<td><input id="scorepicker" /></td>
				<td width="30px"></td>
				<td>总  学  时：</td>
				<td><input id="sumhspicker" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>理论学时：</td>
				<td><input id="thryhspicker" /></td>
				<td width="30px"></td>
				<td>试验学时：</td>
				<td><input id="prtchspicker" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>学  期  1 ：</td>
				<td><input id="fst" /></td>
				<td width="30px"></td>
				<td>学  期  2 ：</td>
				<td><input id="scndt" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>学  期  3 ：</td>
				<td><input id="thirdt" /></td>
				<td width="30px"></td>
				<td>学  期  4 ：</td>
				<td><input id="fortht" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>学  期  5 ：</td>
				<td><input id="fift" /></td>
				<td width="30px"></td>
				<td>学  期  6 ：</td>
				<td><input id="sixt" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>学  期  7 ：</td>
				<td><input id="sevent" /></td>
				<td width="30px"></td>
				<td>学  期  8 ：</td>
				<td><input id="eigt" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;text-align:right;margin-right: 22px">
		<input id="pid" type="hidden">
		<a id="reqoptsave" class="easyui-linkbutton" style="width: 65px;"
			data-options="iconCls:'icon-save'" >保存</a>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dlgCtx/gendialog.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dlgCtx/reoptdialog.js"></script>
</body>
</html>