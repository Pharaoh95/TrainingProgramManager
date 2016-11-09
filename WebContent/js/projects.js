$(function() {
	var table = $('#dg');
	table.datagrid({
		url : '/TrainingProgramManager/findProject.do',
		columns : [ [ {
			field : 'sel',
			title : '选中',
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
			width : 185
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
			align : 'center'
		}, {
			field : 'quality',
			title : '课程性质',
			align : 'center'
		}, {
			field : 'level',
			title : '学历层次',
			align : 'center',
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
			field : 'projectDetails.note',
			title : '备注',
			width : 97,
			align : 'center',
			formatter : function(value, row, index) {
				return row.projectDetails.note;
			}
		}, ] ],
		pagination : true,
		toolbar : '#tb',
		striped : true,
		rownumbers : true,
		pageList : [ 12 ],
		pageSize : 12,
		fit : true,
	});
	initProjSearcher($('#esearchbox'), table);
})

function add() {

}
