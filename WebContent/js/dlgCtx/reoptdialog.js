$(function() {
	$.ajax({
		type : 'POST',
		url : '/TrainingProgramManager/ReqOptProgarm.do',
		success : function(result) {
			$('#pid').val(result.id);
			$('#scorepicker').numberspinner('setValue', result.score);
			$('#sumhspicker').numberspinner('setValue', result.sumHour);
			$('#thryhspicker').numberspinner('setValue', result.theoryHour);
			$('#prtchspicker').numberspinner('setValue', result.practiceHour);
			$('#fst').numberspinner('setValue', result.first);
			$('#scndt').numberspinner('setValue', result.second);
			$('#thirdt').numberspinner('setValue', result.third);
			$('#fortht').numberspinner('setValue', result.forth);
			$('#fift').numberspinner('setValue', result.fifth);
			$('#sixt').numberspinner('setValue', result.sixth);
			$('#sevent').numberspinner('setValue', result.seventh);
			$('#eigt').numberspinner('setValue', result.eighth);
			console.log(result.id);
		}
	});
	// 保存验证
	$('#reqoptsave').click(function() {
		if (!$('#sumhspicker').numberspinner('isValid')) {
			$('#sumhspicker').focus();
			return;
		}
		if (!$('#thryhspicker').numberspinner('isValid')) {
			$('#thryhspicker').focus();
			return;
		}
		if (!$('#prtchspicker').numberspinner('isValid')) {
			$('#prtchspicker').focus();
			return;
		}
		var reqOptedProg = [ {
			id : $('#pid').val(),
			name : '综合教育选修课',
			score : $('#scorepicker').val(),
			sumHour : $('#sumhspicker').val(),
			theoryHour : $('#thryhspicker').val(),
			practiceHour : $('#prtchspicker').val(),
			first : $('#fst').val(),
			second : $('#scndt').val(),
			third : $('#thirdt').val(),
			forth : $('#fortht').val(),
			fifth : $('#fift').val(),
			sixth : $('#sixt').val(),
			seventh : $('#sevent').val(),
			eighth : $('#eigt').val(),
		} ];
		$.ajax({
			type : 'POST',
			contentType : 'application/json;charset=utf-8',
			url : '/TrainingProgramManager/updatePrograms.do',
			data : JSON.stringify(reqOptedProg),
			success : function(result) {
				// loadStatistical();
				$('#opteddialog').dialog('close');
			}
		});
	})
})