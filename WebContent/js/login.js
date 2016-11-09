$(function() {
	// 登录窗口初始化
	$('#login').dialog({
		title : '用户登录',
		width : 300,
		height : 180,
		modal : true,
		buttons : '#bb',
		closable : false
	});
	// 输入框加入验证
	var namebox = $('#username');
	var passbox = $('#password')
	namebox.validatebox({
		required : true,
		missingMessage : '请输入管理员帐号',
		invalidMessage : '管理员帐号不得为空',
	});
	passbox.validatebox({
		required : true,
		validType : 'length[6,12]',
		missingMessage : '请输入管理员密码',
		invalidMessage : '管理员密码在 6-12 位',
	});
	// 登录按钮点击事件
	$('#alodin')
			.click(
					function() {
						if (!namebox.validatebox('isValid')) {
							namebox.focus();
						} else if (!passbox.validatebox('isValid')) {
							passbox.focus();
						} else {
							var password = passbox.val();
							var id = namebox.val();
							$
									.ajax({
										type : 'POST',
										url : '/TrainingProgramManager/isLoginValid.do',
										data : {
											id : id,
											password : $.md5(password),
											character : $(
													'input:radio[name="character"]:checked')
													.val()
										},
										success : function(manager) {
											if (manager != '') {
												window.location = '/TrainingProgramManager/loadIndex.html';
											} else {
												$.messager.alert('错误',
														'账号信息错误或权限不足');
											}
										}
									});
						}
					});
	// 清空输入框
	$('#aclear').click(function() {
		namebox.focus();
		namebox.val('');
		passbox.val('');
	})

})