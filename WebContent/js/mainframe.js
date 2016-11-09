$(function() {
	var fixTabLink = '/TrainingProgramManager/fixTab.html'
	// 组件初始化
	var etab = $('#etab');
	var gentree = $('#gerneraletree');
	var proftree = $('#proftree');
	var addmtree = $('#addmodule');
	var roletree = $('#roletree');

	gentree.tree({
		onClick : function(node) {
			// 主干不创建Tab
			if (!gentree.tree('isLeaf', node.target)) {
				return;
			}
			if (node.id == 'optionedProgram') {
				showOptedDialog();
				return;
			}
			if (!etab.tabs('exists', node.text)) {
				// 没有则创建tab
				etab.tabs('add', {
					title : node.text,
					closable : true,
					href : fixTabLink,
					queryParams : {
						tab : node.id
					},
				});
			} else {
				// 有则选中显示
				etab.tabs('select', node.text);
			}
		}
	});
	proftree.tree({
		url : '/TrainingProgramManager/getCategories.do',
		method : 'POST',
		cache : false,
		onClick : function(node) {
			if (etab.tabs('exists', node.text)) {
				etab.tabs('select', node.text);
				return;
			}
			// 判断专业选修课选项卡是否存在
			var tab = null;
			var nodes = proftree.tree('getRoots');
			for (var i = 0; i < nodes.length; i++) {
				tab = etab.tabs('getTab', nodes[i].text);
				if (tab != null) {
					etab.tabs('select', tab.text);
					break;
				}
			}
			// 把模块Id交给controller
			$.ajax({
				type : 'POST',
				url : '/TrainingProgramManager/setCateId.do',
				data : {
					cateId : node.id
				},
			})
			// 存在且选择了不同模块则更新，不存在则添加选项卡
			if (tab != null) {
				$('#profsave,#profredo').hide();
				// 防止更新时刷新页面而导致的dialog的bug，现在不存在了，不过现在也懒得改了
				tab.panel('options').href = null;
				// 更新标签
				etab.tabs('update', {
					tab : tab,
					options : {
						title : node.text,
					}
				})
				etab.tabs('select', node.text);
				// 表格数据更新
				$('#profOptioneddg').datagrid('load');
			} else {
				etab.tabs('add', {
					title : node.text,
					closable : true,
					href : fixTabLink,
					queryParams : {
						tab : 'profOptioned'
					},
				})
			}
		}
	});
	// 关于账号模块树的初始化
	roletree.tree({
		onClick : function(node) {
			// 这里是一个写得蹩脚的逻辑，不优雅
			if (node.id == 'logout') {
				window.location = '/TrainingProgramManager/logout.html'
				return;
			}
			if (node.id == 'outputProgs') {
				alert('尚未实现导出功能');
				return;
			}
			if (node.id == 'pwdSettings') {
				$('<div></div>').dialog({
					modal : true,
					id : 'pwdSettingDlg',
					title : '用户密码修改',
					left : 184,
					top : 113,
					width : 260,
					height : 190,
					href : fixTabLink,
					queryParams : {
						tab : 'dialogContext/pwdSettingsDlg'
					},
					onClose : function() {
						$(this).dialog('destroy');
					}
				});
				return;
			}
		}
	})
	// 添加模块弹出窗口事件
	addmtree.tree({
		onClick : function(node) {
			if (node.id == 'addModule') {
				$('<div id=\'addmdlg\'></div>').dialog({
					title : '添加模块',
					left : 172,
					top : 162,
					width : 215,
					height : 117,
					modal : true,
					href : fixTabLink,
					onClose : function() {
						$(this).dialog('destroy');
					},
					queryParams : {
						tab : 'dialogContext/moduleDialog',
					},
				});
			}
			if (node.id == "statisticDetails") {
				if (etab.tabs('exists', node.text)) {
					etab.tabs('select', node.text);
					return;
				}
				etab.tabs('add', {
					title : node.text,
					href : fixTabLink,
					closable : true,
					queryParams : {
						tab : 'statisticDetails',
					},
				})
			}

		}
	})

})
// 验证添加事件
function addmodule(mname) {
	if (!mname.validatebox('isValid')) {
		mname.focus();
	} else {
		$.ajax({
			type : 'POST',
			url : '/TrainingProgramManager/insertCategory.do',
			data : {
				text : mname.val(),
			},
			success : function(result) {
				$('#addmdlg').dialog('close');
				$('#proftree').tree('reload');
			}
		});
	}
}