$(function() {
	var statisticDetailsdg = $('#statisticDetailsdg');
	statisticDetailsdg.datagrid({
		// url : '/TrainingProgramManager/loadStatistic.do',
		fit : true,
		columns : [ [ {
			title : '专业方向',
			field : 'category',
			align : 'center',
			width : 120,
			rowspan : 2
		}, {
			title : '综合教育及专业教育',
			align : 'center',
			colspan : 2
		}, {
			title : '实践教学',
			align : 'center',
			colspan : 2
		}, {
			title : '方向专属课程',
			align : 'center',
			colspan : 2
		}, {
			title : '统计总学时',
			align : 'center',
			field : 'statistcSumHour',
			rowspan : 2,
			width : 90,
		}, {
			title : '统计总学分',
			align : 'center',
			field : 'statistcSumScore',
			width : 90,
			rowspan : 2
		} ], [ {
			title : '统计学时',
			field : 'genSumHour',
			align : 'center',
			width : 90,
		}, {
			title : '统计学分',
			field : 'genSumScore',
			align : 'center',
			width : 90,
		}, {
			title : '统计学时',
			field : 'prctcSumHour',
			align : 'center',
			width : 90,
			formatter : function(value, row, index) {
				return row.prctcModHour + row.prctcGenSumHour;
			}
		}, {
			title : '统计学分',
			field : 'prctcSumScore',
			align : 'center',
			width : 90,
			formatter : function(value, row, index) {
				return row.prctcModScore + row.prctcGenSumScore;
			}
		}, {
			title : '统计学时',
			field : 'moduleHour',
			align : 'center',
			width : 90,
		}, {
			title : '统计学分',
			field : 'moduleScore',
			align : 'center',
			width : 90,
		} ] ],
		striped : true,
		singleSelect : true,
	});
	var data = $('#sumHourdg').datagrid('getData');
	statisticDetailsdg.datagrid('loadData', data);
	statisticDetailsdg.datagrid('mergeCells', {
		field : ['genSumHour'],
		index : 0,
		rowspan : data.total
	});
	statisticDetailsdg.datagrid('mergeCells', {
		field : 'genSumScore',
		index : 0,
		rowspan : data.total
	});
})