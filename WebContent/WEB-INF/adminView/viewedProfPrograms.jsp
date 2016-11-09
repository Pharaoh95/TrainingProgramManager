<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table id="viewedProfDg"></table>
	<script type="text/javascript">
		$('#viewedProfDg').datagrid({
			columns : [ [ {
				field : 'name',
				title : '课程名称',
				width : 190,
				align : 'center',
			}, {
				field : 'projectId',
				title : '课程代码',
				width : 80,
				align : 'center',
			}, {
				field : 'score',
				title : '学分',
				width : 45,
				align : 'center',
			}, {
				field : 'sumHour',
				title : '总学时',
				align : 'center',
			}, {
				field : 'weekHour',
				title : '每周学时',
				align : 'center',
			}, {
				field : 'practiceHour',
				title : '实践学时',
				align : 'center',
			}, {
				field : 'teachTerm',
				title : '开课学期',
				align : 'center',
			}, {
				field : 'teachDept',
				title : '授课部门',
				width : 90,
				align : 'center',
			}, ] ],
			width : 960,
			cache : false,
			striped : true,
			fit : true,
			rownumbers : true,
		})
	</script>
</body>
</html>