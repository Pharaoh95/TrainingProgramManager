$(function() {
	var table = $('#requireddg');
	var editIndex = -1;
	// 初始化搜索框
	$('#requiredsb').searchbox({
		prompt : '输入课程名称',
		searcher : function(value, name) {
			if (value == null || value == '') {
				return;
			}
			table.datagrid('load', {
				searchInfo : value
			});
		},
	});

	// 添加建议必修课
	$('#batadd').click(function() {
		$.messager.confirm('确认', '此举将清空已有的条目，请慎重选择', function(r) {
			if (r) {
				$.ajax({
					type : 'POST',
					url : '/TrainingProgramManager/requiredBatch.do',
					success : function(rows) {
						table.datagrid('load');
						$.messager.show({
							title : '提示',
							msg : '共重新添加  ' + rows + ' 必修课信息',
							timeout : 1800,
							showType : 'slide',
						});
					}
				});
			}
		});
	});
	$('#batdelete').click(function() {
		deleteBatch(table, '/TrainingProgramManager/deletePrograms.do');
	});
	// 初始化数据表格
	table.datagrid({
		url : '/TrainingProgramManager/findPrograms.do?moduleId=1',
		columns : [ [ {
			field : 'id',
			title : '选中',
			rowspan : 2,
			checkbox : true,
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
			align : 'center'
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
			align : 'center'
		}, {
			field : 'theoryHour',
			title : '讲课学时',
			align : 'center'
		}, {
			field : 'practiceHour',
			title : '实践学时',
			align : 'center'
		}, {
			field : 'first',
			title : '1',
			width : 30,
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
			formatter : function(value, row, index) {
				if (row.second != '0') {
					return row.second;
				}
			}
		}, {
			field : 'third',
			title : '3',
			width : 30,
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
			formatter : function(value, row, index) {
				if (row.third != '0') {
					return row.third;
				}
			}
		}, {
			field : 'forth',
			title : '4',
			width : 30,
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
			formatter : function(value, row, index) {
				if (row.forth != '0') {
					return row.forth;
				}
			}
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
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					max : 32,
				}
			},
			formatter : function(value, row, index) {
				if (row.eighth != '0') {
					return row.eighth;
				}
			}
		}, {
			field : 'startWeek',
			title : '起始',
			width : 35,
			align : 'center'
		}, {
			field : 'endWeek',
			title : '结束',
			width : 35,
			align : 'center'
		} ] ],
		width : 960,
		striped : true,
		toolbar : '#requireddgtb',
		pagination : true,
		pageSize : 11,
		pageList : [ 11 ],
		fit : true,
		cache : false,
		rownumbers : true,
		onDblClickRow : function(index, row) {
			if (editIndex >= 0) {
				table.datagrid('endEdit', editIndex);
			}
			table.datagrid('beginEdit', index);
			editIndex = index;
			$('#reqsave,#reqredo').show();
		},
	});
	// 结束编辑事件（保存）
	$('#reqsave').click(function() {
		if (editIndex >= 0) {
			table.datagrid('endEdit', editIndex);
		}
		operateDatas(table, '/TrainingProgramManager/updateRequired.do');
		$('#reqsave,#reqredo').hide();
	})
	// 结束编辑事件（撤销）
	$('#reqredo').click(function() {
		$('#reqsave,#reqredo').hide();
		table.datagrid('reload');
	})
})