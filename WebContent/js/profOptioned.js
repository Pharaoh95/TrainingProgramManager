$(function() {
	var ctx = {
		table : $('#profOptioneddg'),
		addDialog : $('#profdialog'),
		savelink : $('#profsave'),
		redolink : $('#profredo'),
	};
	var editIndex = -1;
	ctx.savelink
			.click(function() {
				// 结束行编辑状态
				if (editIndex >= 0) {
					ctx.table.datagrid('endEdit', editIndex);
				}
				// 数据库更新操作
				operateDatas(ctx.table,
						'/TrainingProgramManager/updateProfPrograms.do');
				$('#profsave,#profredo').hide();
			});
	ctx.redolink.click(function() {
		$('#profsave,#profredo').hide();
		ctx.table.datagrid('load');
	});
	ctx.table.datagrid({
		url : '/TrainingProgramManager/findprofPrograms.do',
		columns : [ [ {
			field : 'id',
			title : '选中',
			checkbox : true,
		}, {
			field : 'name',
			title : '课程名称',
			width : 190,
			align : 'center',
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
			width : 45,
			align : 'center',
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
			field : 'weekHour',
			title : '每周学时',
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'weekHour',
					max : 32,
					min : 1,
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
			field : 'teachTerm',
			title : '开课学期',
			align : 'center',
			editor : {
				type : 'numberbox',
				options : {
					valueField : 'teachTerm',
					max : 8,
					min : 1,
					required : true,
				}
			},
		}, {
			field : 'teachDept',
			title : '授课部门',
			width : 90,
			align : 'center',
			editor : {
				type : 'text',
				options : {
					valueField : 'teachDept',
				}
			},
		}, ] ],
		width : 960,
		cache : false,
		striped : true,
		toolbar : '#profOptioneddgtb',
		fit : true,
		rownumbers : true,
		// 同时只能编辑一行的效果
		onDblClickRow : function(index, row) {
			if (editIndex >= 0) {
				ctx.table.datagrid('endEdit', editIndex);
			}
			$('#profsave,#profredo').show();
			ctx.table.datagrid('beginEdit', index);
			editIndex = index;
		},
	});
	// 删除选中
	$('#profdelete').click(function() {
		deleteBatch(ctx.table, '/TrainingProgramManager/deleteprofPrograms.do')
	});
	// 新增对话框加载
	$('#profadd').click(function() {
		// #profdialog
		$('<div id=\'profdialog\'></div>').dialog({
			title : '添加课程',
			closable : true,
			width : 480,
			height : 255,
			// 引用界面
			href : '/TrainingProgramManager/fixTab.do',
			modal : true,
			onClose : function() {
				$(this).dialog('destroy');
			},
			queryParams : {
				tab : 'dialogContext/profDialog'
			},
		})
	});
	$('#mddelete').click(function() {
		$.messager.confirm('确认', '将永久删除，请慎重考虑？', function(r) {
			if (r) {
				var ptree = $('#proftree');
				var etab = $('#etab');
				$.ajax({
					type : 'POST',
					url : '/TrainingProgramManager/deleteCategory.do',
					success : function(rs) {
						var tab = etab.tabs('getSelected');
						var index = etab.tabs('getTabIndex', tab);
						etab.tabs('close', index);
						ptree.tree('reload');
					}
				});
			}
		});

	});
})
