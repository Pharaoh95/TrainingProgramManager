$(function() {
	var oringinalPwd = $('#oringinalPwd');
	var newPwd = $('#newPwd');
	var agnPwd = $('#agnPwd');
	var ensPwd = $('#ensPwdSetting');
	initPwdInput(oringinalPwd);
	initPwdInput(newPwd);
	initPwdInput(agnPwd);
	// 点击验证，成功则修改
	$('#ensPwdSetting').click(function() {
		if (!oringinalPwd.validatebox('isValid')) {
			oringinalPwd.focus();
			return;
		}
		if (!newPwd.validatebox('isValid')) {
			newPwd.focus();
			return;
		}
		if (!agnPwd.validatebox('isValid')) {
			agnPwd.focus();
			return;
		} else {
			if (eval(newPwd.val()) == eval(agnPwd.val())) {
				pwdSettingRemote(oringinalPwd.val(), agnPwd.val())
			} else {
				alert('新密码不相同');
				newPwd.val('');
				agnPwd.val('');
			}
		}
	});
})
function pwdSettingRemote(oldPwd, newPwd) {
	$.ajax({
		type : 'POST',
		url : '/TrainingProgramManager/resetPwd.do',
		data : {
			password : $.md5(oldPwd),
			newPassword : $.md5(newPwd),
		},
		success : function(result) {
			if (result) {
				alert('修改成功');
				$('#pwdSettingDlg').dialog('close');
			} else {
				alert('原密码错误');
				$('#oringinalPwd').val('');
				$('#newPwd').val('');
				$('#agnPwd').val('');
			}
		}
	})
}
function initPwdInput(input) {
	input.validatebox({
		validType : 'length[6,12]',
		invalidMessage : '密码在 6-12 位',
		required : true,
	});
}