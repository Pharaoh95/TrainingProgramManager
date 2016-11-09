$(function() {
	// 对话框组件加载
	$('#addprofname').validatebox({
		required : true,
	});
	$('#profscorepicker').numberspinner({
		width : 100,
		required : true,
		precision : 1,
		decimalSeparator : '.',
		editable : false,
		min : 0.5,
		max : 10.0,
		value : 2.0,
		increment : 0.5
	})
	var profsumhspicker = $('#profsumhspicker');
	var perwkhspicker = $('#perwkhspicker');
	var profprtchspicker = $('#profprtchspicker');
	profsumhspicker.numberspinner({
		required : true,
		width : 100,
		min : 8,
		max : 256,
		value : 64,
		increment : 8,
		onChange : function() {
			var value = profsumhspicker.numberspinner('getValue');
			perwkhspicker.numberspinner('setValue', Math.floor(value / 16));
		}
	})
	perwkhspicker.numberspinner({
		required : true,
		width : 100,
		min : 0,
		max : 40,
		value : 4,
		increment : 1,
		onChange : function() {
			var value = profsumhspicker.numberspinner('getValue');
			if (eval(perwkhspicker.numberspinner('getValue')) > eval(value)) {
				perwkhspicker.numberspinner('setValue', value);
			}
		}
	})
	profprtchspicker
			.numberspinner({
				required : true,
				width : 100,
				min : 0,
				value : 0,
				increment : 4,
				onChange : function() {
					var value = profsumhspicker.numberspinner('getValue');
					if (eval(profprtchspicker.numberspinner('getValue')) > eval(value)) {
						profprtchspicker.numberspinner('setValue', value);
					}
				}
			})

	$('#termspicker').numberspinner({
		width : 100,
		required : true,
		editable : false,
		min : 1,
		max : 8,
		value : 5,
		increment : 1
	});
	// 
	$('#addprofpid').blur(
			function() {
				$.ajax({
					type : 'POST',
					url : '/TrainingProgramManager/findTransedProgram.do',
					data : {
						projectId : $("#addprofpid").val()
					},
					success : function(result) {
						if (result == '') {
							return;
						}
						// 载入信息到控件中
						$('#addprofname').val(result.name);
						$('#profsumhspicker').val(result.sumHour);
						$('#profprtchspicker').val(result.practiceHour);
						$('#addprofdpt').val(result.teachDept);
						$('#profscorepicker').val(result.score);
						perwkhspicker.numberspinner('setValue', Math
								.floor(result.sumHour / 16));
					}
				});

			})
	// 保存添加
	$('#porfdlgsave').click(function() {
		// 表单验证
		if (!$('#addprofname').validatebox('isValid')) {
			$('#addprofname').focus();
			// alert(profsumhspicker.numberspinner('getValue'));
			return;
		}
		if (!profsumhspicker.numberspinner('isValid')) {
			profsumhspicker.focus();
			return;
		}
		if (!perwkhspicker.numberspinner('isValid')) {
			perwkhspicker.focus();
			return;
		}
		if (!profprtchspicker.numberspinner('isValid')) {
			profprtchspicker.focus();
			return;
		}

		// 验证通过提交到服务器
		$.ajax({
			type : 'POST',
			url : '/TrainingProgramManager/insertProfProgram.do',
			data : {
				name : $('#addprofname').val(),
				projectId : $('#addprofpid').val(),
				score : $('#profscorepicker').val(),
				sumHour : profsumhspicker.val(),
				weekHour : perwkhspicker.val(),
				practiceHour : profprtchspicker.val(),
				teachTerm : $('#termspicker').val(),
				teachDept : $('#addprofdpt').val(),
			},
			success : function(result) {
				// 更新数据表格
				if (result) {
					$('#profOptioneddg').datagrid('load');
				}
				resetdialog();
			}
		})
	})
})
function resetdialog() {
	$('#addprofname').val('');
	$('#addprofpid').val('');
	$('#addprofdpt').val('');
	$('#profsumhspicker').numberspinner('reset');
	$('#perwkhspicker').numberspinner('reset');
	$('#profprtchspicker').numberspinner('reset');
	$('#profscorepicker').numberspinner('reset');
	$('#termspicker').numberspinner('reset');
}