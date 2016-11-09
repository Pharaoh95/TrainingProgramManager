<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table id="viewedGenDg"></table>
	<script type="text/javascript">
		$('#viewedGenDg').datagrid({
			columns : [ [ {
				field : 'scndCate',
				title : '分类',
				align : 'center',
				width : 100,
				rowspan : 2,
				hidden : true
			}, {
				field : 'name',
				title : '课程名称',
				align : 'center',
				width : 200,
				rowspan : 2,
			}, {
				field : 'projectId',
				title : '课程代码',
				rowspan : 2,
				width : 80,
				align : 'center',
			}, {
				field : 'score',
				title : '学分',
				align : 'center',
				width : 45,
				rowspan : 2,
			}, {
				title : '学时统计',
				align : 'center',
				colspan : 3,
			}, {
				title : '一学年',
				align : 'center',
				colspan : 2,
			}, {
				title : '二学年',
				align : 'center',
				colspan : 2,
			}, {
				title : '三学年',
				align : 'center',
				colspan : 2,
			}, {
				title : '四学年',
				align : 'center',
				colspan : 2,
			}, {
				title : '起止周',
				align : 'center',
				colspan : 2,
			}, {
				field : 'teachDept',
				title : '授课单位',
				align : 'center',
				width : 90,
				rowspan : 2,
			}, ], [ {
				field : 'sumHour',
				title : '总学时',
				align : 'center',
			}, {
				field : 'theoryHour',
				title : '讲课学时',
				align : 'center',
			}, {
				field : 'practiceHour',
				title : '实践学时',
				align : 'center',
			}, {
				field : 'first',
				title : '1',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.first != '0') {
						return row.first;
					}
				}
			}, {
				field : 'second',
				title : '2',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.second != '0') {
						return row.second;
					}
				},
			}, {
				field : 'third',
				title : '3',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.third != '0') {
						return row.third;
					}
				},
			}, {
				field : 'forth',
				title : '4',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.forth != '0') {
						return row.forth;
					}
				},
			}, {
				field : 'fifth',
				title : '5',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.fifth != '0') {
						return row.fifth;
					}
				},
			}, {
				field : 'sixth',
				title : '6',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.sixth != '0') {
						return row.sixth;
					}
				},
			}, {
				field : 'seventh',
				title : '7',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.seventh != '0') {
						return row.seventh;
					}
				},
			}, {
				field : 'eighth',
				title : '8',
				width : 30,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.eighth != '0') {
						return row.eighth;
					}
				},
			}, {
				field : 'startWeek',
				title : '起始',
				width : 35,
				align : 'center',
			}, {
				field : 'endWeek',
				title : '结束',
				width : 35,
				align : 'center',
			} ] ],
			rownumbers : true,
			singleSelect : true,
			cache : false,
			width : 960,
			striped : true,
			fit : true,
		});
	</script>
</body>
</html>