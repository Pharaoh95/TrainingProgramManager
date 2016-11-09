$(function() {
	// 控件及数据初始化
	var adviceNormDg = $('#adviceNormDg');
	var editIndex = -1;
	var parentlink = '/TrainingProgramManager/adminController/';
	// 事件初始化
	$('#adviceNormRedo').click(function() {
		refreshTable(adviceNormDg);
		$('#adviceNormSave,#adviceNormRedo').hide();
	})
	$('#adviceNormSave').click(function() {
		operateDatas(adviceNormDg, parentlink + 'updateAdvicedNorms.do');
		$('#adviceNormSave,#adviceNormRedo').hide();
	})
	// 表格初始化
	adviceNormDg.datagrid({
		url : parentlink + 'findAdvicedNorms.do',
		columns : [ [ {
			field : 'majorCategory',
			title : '专业类别',
			align : 'center',
			width : 150,
		}, {
			field : 'maxSumHour',
			title : '总学时上限',
			align : 'center',
			width : 150,
			editor : {
				type : 'numberbox',
				options : {
					required : true,
					max : 3500,
					min : 1600
				}
			},
		}, {
			field : 'minSumScore',
			title : '总学分下限',
			align : 'center',
			width : 150,
			editor : {
				type : 'numberbox',
				options : {
					required : true,
					max : 180,
					min : 80,
					precision : 1,
				}
			},
		}, {
			field : 'maxSumScore',
			title : '总学分上限',
			align : 'center',
			width : 150,
			editor : {
				type : 'numberbox',
				options : {
					required : true,
					max : 240,
					min : 180,
					precision : 1,
				}
			},
		} ] ],
		striped : true,
		rownumbers : true,
		pageList : [ 12 ],
		pageSize : 12,
		fit : true,
		toolbar : '#adviceNormDgTb',
		singleSelect : true,
		onDblClickRow : function(index, row) {
			if (editIndex >= 0) {
				adviceNormDg.datagrid('endEdit', editIndex);
			}
			adviceNormDg.datagrid('beginEdit', index);
			$('#adviceNormSave,#adviceNormRedo').show();
			editIndex = index;
		},
	})
})