<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="padding: 7px;">
		<table>	
			<tr>
				<td>课程名称：</td>
				<td><input id="addpname" style="width: 149px;" class="easyui-validatebox"
					data-options="required:true,validType:'length[2,12]',missingMessage:'不得为空'" />
				</td>
				<td width="20px"></td>
				<td>课程代码：</td>
				<td><input id="addpid" style="width: 120px;" /></td>
			</tr>
		</table>
		
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>课程学分：</td>
				<td><input id="scorepicker" /></td>
				<td width="74px"></td>
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
				<td width="74px"></td>
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
				<td width="74px"></td>
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
				<td width="74px"></td>
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
				<td width="74px"></td>
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
				<td width="74px"></td>
				<td>学  期  8 ：</td>
				<td><input id="eigt" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>起  始  周：</td>
				<td><input id="startwk" /></td>
				<td width="74px"></td>
				<td>结  束  周：</td>
				<td><input id="endwk" /></td>
			</tr>
		</table>
	</div>
	<div style="padding: 7px;">
		<table>
			<tr>
				<td>授课单位：</td>
				<td><input id="prodept" style="width: 140px;" class="easyui-textbox"/></td>
				<td width="35px"></td>
				<td>实践分类：</td>
				<td><input id="scndcate" /></td>
			</tr>
		</table>
	</div>
	<input id="gendlgtid" type="hidden" value="${tableId}">
	<div style="padding: 7px;text-align:right;margin-right: 20px">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"
				style="width: 65px;" onclick="genprosave()">保存</a>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dlgCtx/gendialog.js"></script>
</body>
</html>