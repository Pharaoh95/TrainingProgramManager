$(function() {
	var table = $('#dg');
	var editIndex = -1;
	initProjSearcher($('#esearchbox'), table);
	var imptBtn = $('#ensureImpt');
	// 编辑撤销事件
	$('#aprojredo').click(function() {
		table.datagrid('reload');
		$('#aprojsave,#aprojredo').hide();
	})
	
	// 编辑保存事件
	$('#aprojsave').click(function() {
		table.datagrid("endEdit", editIndex);
		operateDatas(table, '/TrainingProgramManager/updateProjects.do');
		$('#aprojsave,#aprojredo').hide();
	})
	// 控件初始化
	$('#imptProjs').filebox({
		buttonText : '选择文件',
		width : 170,
		prompt : '<2M 的  xlsx、xls',
		onChange : function(newValue, oldValue) {
			if (newValue != '' && newValue != null) {
				$('#ensureImpt').show();
			}
		}
	});
	// 确认导入文件进行解析
	imptBtn.click(function() {
		var fd = new FormData($('#imptForm')[0]);
		$.ajax({
			url : '/TrainingProgramManager/adminController/importFile.do',
			type : 'POST',
			data : fd,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(rs) {
				switch (rs) {
				case 1: {
					alert('导入成功');
					$('#imptProjs').filebox('reset');
					imptBtn.linkbutton('enable');
					imptBtn.hide();
					table.datagrid('load');
					break;
				}
				case 2: {
					alert('文件错误');
					imptBtn.linkbutton('enable');
					break;
				}
				default:
					break;
				}
			},
			beforeSend : function() {
				imptBtn.linkbutton('disable');
			},
			error : function(rs) {
				imptBtn.linkbutton('enable');
				alert('解析失败');
			}
		});
	})
	table.datagrid({
		url : '/TrainingProgramManager/findProject.do',
		columns : [ [ {
			title : '选中',
			field : 'sel',
			align : 'center',
			checkbox : true,
		}, {
			field : 'id',
			title : '课程代码',
			align : 'center',
			sortable : true
		}, {
			field : 'name',
			title : '课程名称',
			align : 'center',
			width : 185,
		}, {
			field : 'score',
			title : '学分',
			align : 'center',
		}, {
			field : 'weekHours',
			title : '周学时',
			align : 'center',
		}, {
			field : 'sumHours',
			title : '总学时',
			align : 'center',
			sortable : true
		}, {
			field : 'theoryHours',
			title : '讲课学时',
			align : 'center'
		}, {
			field : 'practiceHours',
			title : '试验学时',
			align : 'center'
		}, {
			field : 'type',
			title : '课程类别',
			align : 'center',
			width : 88,
			editor : {
				type : 'combobox',
				options : {
					panelHeight : 105,
					required : true,
					editable : false,
					valueField : 'label',
					textField : 'value',
					data : [ {
						label : '综合教育课',
						value : '综合教育课'
					}, {
						label : '专业基础课',
						value : '专业基础课'
					}, {
						label : '实践教学课',
						value : '实践教学课'
					}, {
						label : '文理基础课',
						value : '文理基础课'
					}, {
						label : '专业教育课',
						value : '专业教育课'
					} ]
				}
			},
		}, {
			field : 'quality',
			title : '课程性质',
			align : 'center',
			width : 65,
			editor : {
				type : 'combobox',
				options : {
					panelHeight : 88,
					required : true,
					valueField : 'label',
					editable : false,
					textField : 'value',
					data : [ {
						label : '必修课',
						value : '必修课'
					}, {
						label : '院选课',
						value : '院选课'
					}, {
						label : '公选课',
						value : '公选课'
					}, {
						label : '方向课',
						value : '方向课'
					} ]
				}
			}
		}, {
			field : 'level',
			title : '学历层次',
			align : 'center',
			width : 65,
			editor : {
				type : 'combobox',
				options : {
					required : true,
					panelHeight : 69,
					editable : false,
					valueField : 'label',
					textField : 'value',
					data : [ {
						label : '本科',
						value : '本科'
					}, {
						label : '专科',
						value : '专科'
					}, {
						label : '本专科',
						value : '本专科'
					} ]
				}
			}
		}, {
			field : 'createdDpt',
			title : '开课部门',
			align : 'center',
		}, {
			field : 'projectDetails.dptId',
			title : '开课部门代码',
			align : 'center',
			formatter : function(value, row, index) {
				return row.projectDetails.dptId;
			}
		}, {
			field : 'projectDetailsNote',
			title : '备注',
			width : 97,
			align : 'center',
			editor : {
				type : 'text',
				options : {
					onblur : function() {
						alert('test');
					}
				}
			},
		}, ] ],
		pagination : true,
		toolbar : '#tb',
		striped : true,
		rownumbers : true,
		pageList : [ 12 ],
		pageSize : 12,
		fit : true,
		onDblClickRow : function(index, row) {
			if (editIndex >= 0) {
				table.datagrid("endEdit", editIndex);
			}
			$('#aprojsave,#aprojredo').show();
			table.datagrid("beginEdit", index);
			editIndex = index;
		}
	});

})

function drop() {
	deleteBatch($('#dg'), '/TrainingProgramManager/deleteProjects.do');
}