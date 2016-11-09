// 显示选修课窗口
function showOptedDialog() {
	$('<div></div>').dialog({
		modal : true,
		id : 'opteddialog',
		title : '综合教育->选修课设置',
		left : 184,
		top : 113,
		width : 420,
		height : 335,
		href : '/TrainingProgramManager/fixTab.do',
		onClose : function() {
			$(this).dialog('destroy');
		},
		queryParams : {
			tab : 'dialogContext/optedDialog',
		},
	});
}
// 批量删除
function deleteBatch(table, link) {
	var selected = table.datagrid('getSelections');
	if (selected.length <= 0) {
		return;
	}
	$.messager.confirm('确认', '您确认要删除选中条目吗？', function(r) {
		if (r) {
			// ajax访问数据库删除选中的条目
			$.ajax({
				type : 'POST',
				contentType : 'application/json;charset=utf-8',
				url : link,
				data : JSON.stringify(selected),
				success : function(rows) {
					table.datagrid('reload');
					$.messager.show({
						title : '提示',
						msg : '共有  ' + rows + ' 条数据被删除',
						timeout : 1800,
						showType : 'slide',
					});
				}
			});
		}
	});
}
// 显示增加课程窗口
function showProDialog(tbname, scndCate) {
	// dialog参数莫名其妙传不到后台，将就一下发两遍请求
	$.ajax({
		type : 'POST',
		data : {
			scndCate : scndCate,
			tableId : tbname
		},
		url : '/TrainingProgramManager/setScndCateAndTid.do',
	});
	// 创建窗口
	$('<div></div>').dialog({
		modal : true,
		id : 'genprodialog',
		title : '添加课程',
		width : 495,
		height : 460,
		href : '/TrainingProgramManager/genDialog.do',
		onClose : function() {
			$(this).dialog('destroy');
		}
	});
}
// 总学时，理论学时，实践学时数值联动事件，通用
function cascadepicker(dad, self, brother) {
	var selfvalue = self.numberspinner('getValue');
	var dadvalue = dad.numberspinner('getValue');
	if (eval(dadvalue) < eval(selfvalue)) {
		self.numberspinner('setValue', dadvalue);
	}
	var brothervalue = dadvalue - self.numberspinner('getValue');
	brother.numberspinner('setValue', brothervalue);
}
/*
 * 表格数据删除、更新通用方法
 */
function operateDatas(table, link) {
	var data = table.datagrid('getRows');
	$.ajax({
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		url : link,
		data : JSON.stringify(data),
		success : function(result) {
			console.log(result);
			table.datagrid('reload');
		},
		error : function(result) {
			$.messager.show({
				title : '错误提示',
				msg : '表格数据更新失败',
				timeout : 1000,
				showType : 'slide',
			});
		}
	});
}
function refreshTable(table) {
	table.datagrid('reload', {});
}
function initProjSearcher(searcher, table) {
	searcher.searchbox({
		searcher : function(value, name) {
			if (value == null || value == '') {
				return;
			}
			table.datagrid('load', {
				searchInfo : value
			});
		},
		prompt : '请输入代码或名称',
	});
}