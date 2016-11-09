$(function() {
	$('#scorepicker').numberspinner({
		required : true,
		precision : 1,
		decimalSeparator : '.',
		editable : false,
		width : 100,
		min : 0.5,
		max : 10.0,
		value : 2.0,
		increment : 0.5
	})
	var sumhspicker = $('#sumhspicker');
	var thryhspicker = $('#thryhspicker');
	var prtchspicker = $('#prtchspicker');
	sumhspicker.numberspinner({
		required : true,
		value : 32,
		min : 0,
		width : 100,
		max : 256,
		increment : 8,
		onChange : function() {
			var v = sumhspicker.spinner('getValue')
					- prtchspicker.spinner('getValue');
			if (eval(v) < 0) {
				prtchspicker.spinner('setValue', sumhspicker
						.spinner('getValue'));
				return;
			}
			thryhspicker.spinner('setValue', v);
		}
	});
	thryhspicker.numberspinner({
		width : 100,
		required : true,
		value : 32,
		max : 256,
		min : 0,
		increment : 8,
		onChange : function() {
			cascadepicker(sumhspicker, thryhspicker, prtchspicker);
		}
	});
	prtchspicker.numberspinner({
		required : true,
		width : 100,
		value : 0,
		min : 0,
		max : 256,
		increment : 8,
		onChange : function() {
			cascadepicker(sumhspicker, prtchspicker, thryhspicker);
		}
	});
	initTermSpinner($('#fst'));
	initTermSpinner($('#scndt'));
	initTermSpinner($('#thirdt'));
	initTermSpinner($('#fortht'));
	initTermSpinner($('#fift'));
	initTermSpinner($('#sixt'));
	initTermSpinner($('#sevent'));
	initTermSpinner($('#eigt'));
	$('#startwk').numberspinner({
		value : 1,
		width : 100,
		min : 1,
		max : 16,
		editable : false,
		requied : true,
		onChange : function() {
			cascadestend();
		}
	});
	$('#endwk').numberspinner({
		value : 16,
		width : 100,
		min : 1,
		max : 16,
		editable : false,
		requied : true,
		onChange : function() {
			cascadestend()
		}
	});
	$('#scndcate').combobox({
		width : 131,
		url : '/TrainingProgramManager/getCategories.do',
		panelHeight : 150,
		valueField : 'text',
		textField : 'text',
		onChange : function(newValue, oldValue) {
			$('#scndcate').val(newValue);
		}
	})

	$("#addpid").blur(
			function() {
				$.ajax({
					type : 'POST',
					url : '/TrainingProgramManager/findTransedProgram.do',
					data : {
						projectId : $("#addpid").val()
					},
					success : function(result) {
						if (result == '') {
							return;
						}
						// 载入信息到控件中
						$('#addpname').val(result.name);
						$('#scorepicker').numberspinner('setValue',
								result.score);
						$('#sumhspicker').numberspinner('setValue',
								result.sumHour);
						$('#thryhspicker').numberspinner('setValue',
								result.theoryHour);
						$('#prtchspicker').numberspinner('setValue',
								result.practiceHour);
						$('#startwk').numberspinner('setValue',
								result.startWeek);
						$('#endwk').numberspinner('setValue', result.endWeek);
						$('#prodept').val(result.teachDept);
					}
				});
			});
})
// 验证保存按钮事件，
function genprosave() {
	var proname = $('#addpname');
	if (!proname.validatebox('isValid')) {
		proname.focus();
		return;
	}
	var genProgObj = {
		name : proname.val(),
		projectId : $('#addpid').val(),
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
		startWeek : $('#startwk').val(),
		endWeek : $('#endwk').val(),
		scndCate : $('#scndcate').val(),
		teachDept : $('#prodept').val()
	};
	$.ajax({
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		url : '/TrainingProgramManager/insertProgram.do',
		data : JSON.stringify(genProgObj),
		success : function(result) {
			var tid = $('#gendlgtid').val();
			$(tid).datagrid('load');
			// loadStatistical();
			$('#genprodialog').dialog('close');
		}
	});
}
function initTermSpinner(termspinner) {
	termspinner.numberspinner({
		width : 100,
		value : 0,
		min : 0,
		max : 16,
		editable : false,
	});
}
function cascadestend() {
	var start = $('#startwk').numberspinner('getValue');
	var end = $('#endwk').numberspinner('getValue');
	if (start - end > 0) {
		$('#startwk').numberspinner('setValue', end);
	}
}