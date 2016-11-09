$(function() {
	// 初始化数据表格
	var scndCate = 30;
	var editIndex = -1;
	var table = $('#practicedg');
	// 初始化搜索框
	initProjSearcher($('#practicesb'), table);
	table.datagrid({
		url : '/TrainingProgramManager/findPrograms.do?moduleId=' + scndCate,
		columns : [ [ {
			field : 'id',
			title : '选中',
			rowspan : 2,
			checkbox : true,
		}, {
			field : 'scndCate',
			title : '分类',
			align : 'center',
			width : 100,
			rowspan : 2,
			editor : {
				type : 'combobox',
				options : {
					url : '/TrainingProgramManager/getCategories.do',
					panelHeight : 150,
					valueField : 'text',
					textField : 'text',
				}
			}
		}, {
			field : 'name',
			title : '课程名称',
			align : 'center',
			width : 200,
			rowspan : 2,
			editor : {
				type : 'validatebox',
				options : {
					valueField : 'name',
					required : true
				}
			},
		}, {
			field : 'projectId',
			title : '课程代码',
			rowspan : 2,
			width : 80,
			align : 'center',
			editor : {
				type : 'text',
				options : {
					valueField : 'projectId',
				}
			},
		}, {
			field : 'score',
			title : '学分',
			align : 'center',
			width : 45,
			rowspan : 2,
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'score',
					required : true,
					precision : 1,
					max : 10.0,
				}
			},
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
			editor : {
				type : 'text',
				options : {
					valueField : 'teachDept',
				}
			},
		}, ], [ {
			field : 'sumHour',
			title : '总学时',
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'sumHour',
					max : 256,
					min : 8,
					required : true,
				}
			},
		}, {
			field : 'theoryHour',
			title : '讲课学时',
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'theoryHour',
					max : 256,
					min : 0,
					required : true,
				}
			},
		}, {
			field : 'practiceHour',
			title : '实践学时',
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'practiceHour',
					max : 256,
					min : 0,
					required : true,
				}
			},
		}, {
			field : 'first',
			title : '1',
			width : 30,
			align : 'center',
			formatter : function(value, row, index) {
				if (row.first != '0') {
					return row.first;
				}
			},
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
		}, {
			field : 'startWeek',
			title : '起始',
			width : 35,
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'startWeek',
					max : 20,
					min : 1,
					required : true,
				}
			},
		}, {
			field : 'endWeek',
			title : '结束',
			width : 35,
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'endWeek',
					max : 20,
					min : 1,
					required : true,
				}
			},
		} ] ],
		rownumbers : true,
		width : 960,
		striped : true,
		toolbar : '#practicedgtb',
		fit : true,
		cache : false,
		onDblClickRow : function(index, row) {
			if (editIndex >= 0) {
				table.datagrid('endEdit', editIndex);
			}
			table.datagrid('beginEdit', index);
			editIndex = index;
			$('#prctcsave,#prctcredo').show();
		},
	});
	// 结束编辑事件（保存）
	$('#prctcsave').click(function() {
		if (editIndex >= 0) {
			table.datagrid('endEdit', editIndex);
		}
		operateDatas(table, '/TrainingProgramManager/updatePrograms.do');
		$('#prctcsave,#prctcredo').hide();
	})
	// 结束编辑事件（撤销）
	$('#prctcredo').click(function() {
		$('#prctcsave,#prctcredo').hide();
		table.datagrid('load');
	})
	// 显示新增窗口
	$('#prctcadd').click(function() {
		showProDialog('#practicedg', scndCate);
	});
	// 删除选中
	$('#prctcdel').click(function() {
		deleteBatch(table, '/TrainingProgramManager/deletePrograms.do');
	});
})