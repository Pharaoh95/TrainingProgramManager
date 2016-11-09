$(function() {
	$('#mngerdlgclear').click(function() {
		clearForm();
	});
	$('#mngerdlgsave').click(function() {
		if (!$('#addmngerid').validatebox('isValid')) {
			$('#addmngerid').focus();
			return;
		}
		if (!$('#addmngername').validatebox('isValid')) {
			$('#addmngername').focus();
			return;
		}
	})
	// 控件初始化
	$('#addmngerlv').combobox({
		valueField : 'rid',
		textField : 'rname',
		panelHeight : 65,
		value : 2,
		required : true,
		editable : false,
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
	});
	$('#addmngerdpt').combobox({
		valueField : 'id',
		textField : 'name',
		value : '-1',
		required : true,
		url : '/TrainingProgramManager/findAllMajors.do',
		editable : false,
	});

});
function clearForm() {
	$('#addmngerid').val('');
	$('#addmngername').val('');
	$('#addmngerlv').combobox('reset');
	$('#addmngerdpt').combobox('reset');
}