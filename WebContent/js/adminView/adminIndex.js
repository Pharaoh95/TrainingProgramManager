$(function() {
	var gentree = $('#gerneraletree');
	var etab = $('#etab');

	gentree.tree({
		onClick : function(node) {
			// 主干不创建Tab
			if (!gentree.tree('isLeaf', node.target)) {
				return;
			}
			if (!etab.tabs('exists', node.text)) {
				// 没有则创建tab
				etab.tabs('add', {
					title : node.text,
					closable : true,
					href : '/TrainingProgramManager/fixTab.do?tab=' + node.id,
				});
			} else {
				// 有则选中显示
				etab.tabs('select', node.text);
			}
		}
	});
	$('#querableMajorTree').tree({
		url : '/TrainingProgramManager/adminController/loadQuerableMajors.do',
		onClick : function(node) {
			var link = "adminController/queryMajorProgs"
			var param = "?majorId=" + node.id;
			newWin = window.open("/TrainingProgramManager/" + link + param)
			newWin.onload = function() {
				newWin.document.title = node.text;
			}
		}
	})
})