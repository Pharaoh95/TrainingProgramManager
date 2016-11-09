$(function() {
	var sumHourdg = $('#sumHourdg');
	var sumScoredg = $('#sumScoredg');
	loadStatistical();
	sumHourdg.datagrid({
		columns : [ [ {
			title : '总学时',
			colspan : 3,
		} ], [ {
			field : 'category',
			title : '分方向',
			width : 92,
			align : 'center',
		}, {
			field : 'statistcSumHour',
			title : '当前',
			width : 50,
			align : 'center',
			styler : function(value, row, index) {
				if (row.statistcSumHour - 64 > row.adviceHour) {
					return 'color:red;';
				}
			}
		}, {
			field : 'adviceHour',
			title : '建议',
			width : 50,
			align : 'center',
		} ] ],
		striped : true,
		singleSelect : true,
		checkOnSelect : false,
	});
	sumScoredg
			.datagrid({
				columns : [
						[ {
							title : '总学分',
							colspan : 3,
						} ],
						[
								{
									field : 'category',
									title : '分方向',
									width : 92,
									align : 'center',
								},
								{
									field : 'statistcSumScore',
									title : '当前',
									width : 50,
									align : 'center',
									styler : function(value, row, index) {
										if (row.statistcSumScore > row.adviceMaxScore
												|| row.statistcSumScore < row.adviceMinScore) {
											return 'color:red;';
										}
									}

								},
								{
									field : 'adviceScore',
									title : '建议',
									width : 50,
									formatter : function(value, row, index) {
										return row.adviceMinScore + '-'
												+ row.adviceMaxScore;
									},
									align : 'center',
								} ] ],
				striped : true,
				singleSelect : true,
				checkOnSelect : false,
			});
})
function loadStatistical() {
	var statstcParam = ''
	var s = window.location.search;
	var urlRegex = /majorId=(\d+)/;
	if (urlRegex.test(s)) {
		statstcParam = '?viewedMajorId=' + urlRegex.exec(s)[1];
	}
	$.ajax({
		url : '/TrainingProgramManager/loadStatistic.do' + statstcParam,
		type : 'POST',
		cache : false,
		success : function(data) {
			$('#sumHourdg').datagrid('loadData', data);
			$('#sumScoredg').datagrid('loadData', data);
			// 单元格合并
			$('#sumHourdg').datagrid('mergeCells', {
				index : 0,
				field : 'adviceHour',
				rowspan : data.length
			})
			$('#sumScoredg').datagrid('mergeCells', {
				index : 0,
				field : 'adviceScore',
				rowspan : data.length
			})
		}
	});
}