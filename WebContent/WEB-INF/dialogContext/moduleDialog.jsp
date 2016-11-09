<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="padding: 6px; text-align: center;margin-top: 3px" >
		<table align="center">
			<tr>
				<td >名称：</td>
				<td><input id="addmname" style="width: 120px;"  class="easyui-validatebox"
					data-options="required:true,validType:'length[3,10]'" /></td>
			</tr>
		</table>
		<div style="padding: 3px">
			<table align="center">
				<tr>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"
							style="width: 65px" onclick="addmodule($('#addmname'))">保存</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>