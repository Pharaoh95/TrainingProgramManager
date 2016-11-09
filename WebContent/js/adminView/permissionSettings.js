$(function() {
	var managerDg = $('#managerDg');
	var editIndex = -1;
	var parentlink = '/TrainingProgramManager/adminController/'
	initProjSearcher($('#managerSb'), managerDg);
	// 保存修改
	$('#mngerSave').click(function() {
		// 结束行编辑状态
		if (editIndex >= 0) {
			managerDg.datagrid('endEdit', editIndex);
		}
		console.info(managerDg.datagrid('getRows'));
		operateDatas(managerDg, parentlink + 'updateManagers.do');
		$('#mngerSave,#mngerRedo').hide();
	});
	// 撤销修改
	$('#mngerRedo').click(function() {
		managerDg.datagrid('reload');
		$('#mngerSave,#mngerRedo').hide();
	});
	// 表格初始化
	managerDg.datagrid({
		url : '/TrainingProgramManager/findManagers.do',
		columns : [ [ {
			field : 'sel',
			checkbox : true
		}, {
			field : 'id',
			title : 'ID',
			width : 120,
			align : 'center'
		}, {
			field : 'name',
			title : '账号名称',
			width : 120,
			align : 'center'
		}, {
			field : 'level',
			title : '权限等级',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				if (row.level <= 1) {
					return '无权限';
				}
				if (row.level <= 3) {
					return '可维护专业方案';
				} else {
					return '最高级权限';
				}
			},
			editor : {
				type : 'combobox',
				options : {
					panelHeight : 65,
					required : true,
					editable : false,
					valueField : 'rid',
					textField : 'rname',
					data : [ {
						rid : 1,
						rname : '无权限'
					}, {
						rid : 2,
						rname : '可维护专业方案'
					}, {
						rid : 4,
						rname : '最高级权限'
					} ]
				}
			},
		}, {
			field : 'maintainMajorName',
			title : '维护专业',
			width : 170,
			align : 'center',
			editor : {
				type : 'combobox',
				options : {
					required : true,
					editable : false,
					valueField : 'name',
					textField : 'name',
					url : '/TrainingProgramManager/findAllMajors.do',
					onSelect : function(record) {
						var managers = managerDg.datagrid('getRows');
						// Js的动态类型特性本可以直接maintainMajor = record
						// 可是springMVC会解析失败，出现类型不匹配的错误而返回http400（Bad Request）
						// 所以只能将所需属性一个个复制，这里我只需要id
						managers[editIndex].maintainMajor.id = record.id;
					}
				}
			},
		}, {
			field : 'scndCollege',
			title : '所属单位',
			width : 170,
			align : 'center'
		} ] ],
		rownumbers : true,
		striped : true,
		cache : false,
		fit : true,
		pagination : true,
		pageSize : 12,
		pageList : [ 12 ],
		toolbar : '#managerDgTb',
		onDblClickRow : function(index, row) {
			if (editIndex >= 0) {
				managerDg.datagrid('endEdit', editIndex);
			}
			managerDg.datagrid('beginEdit', index);
			$('#mngerSave,#mngerRedo').show();
			editIndex = index;
		},
	});
})