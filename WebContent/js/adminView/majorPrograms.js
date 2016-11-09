$(function() {
	var parentlink = '/TrainingProgramManager/adminController/';
	var s = window.location.search;
	// 在服务端判断参数合法性
	$.ajax({
		url : parentlink + 'isViewedValid.do' + s,
		type : 'POST',
		success : function(rs) {
			if (!rs) {
				window.location.href = '/TrainingProgramManager/error';
			}
		}
	});
	var queryMenutree = $('#queryMenutree');
	var viewedProfTree = $('#viewedProfTree');
	// 通过正则表达式获取专业id(也有其他方式)
	var urlRegex = /majorId=(\d+)/;
	var majorId = urlRegex.exec(s)[1];
	var dataTab = $('#dataTab');
	var tabChooses = [];
	queryMenutree.tree({
		onClick : function(node) {
			// 父节点不创建Tab
			if (!queryMenutree.tree('isLeaf', node.target)) {
				return;
			}
			// 已创建通常数据tab，且为所需数据则显示
			if (dataTab.tabs('exists', node.text)) {
				dataTab.tabs('select', node.text);
				return;
			}
			// 判断是否已创建通常数据tab
			var tab = null;
			for (var i = 0; i < tabChooses.length; i++) {
				tab = dataTab.tabs('getTab', tabChooses[i].text)
				if (tab != null) {
					dataTab.tabs('select', tab.text);
					break;
				}
			}
			// 根据结果操作tab
			if (tab == null) {
				dataTab.tabs('add', {
					title : node.text,
					href : '/TrainingProgramManager/fixTab.do',
					closable : true,
					queryParams : {
						tab : 'adminView/viewedGenPrograms',
					}
				})
			} else {
				// 禁止update时刷新页面,节省网络连接性能同时更好的用户体验
				tab.panel('options').href = null;
				// 更新标签
				dataTab.tabs('update', {
					tab : tab,
					options : {
						title : node.text,
					}
				})
			}
			// 更新表格数据
			if (node.id != '30') {
				$('#viewedGenDg').datagrid('hideColumn', 'scndCate');
			} else {
				$('#viewedGenDg').datagrid('showColumn', 'scndCate');
			}
			$.ajax({
				type : 'POST',
				url : parentlink + 'findPrograms.do',
				data : {
					majorId : majorId,
					moduleId : node.id
				},
				success : function(result) {
					$('#viewedGenDg').datagrid('loadData', result);
				},
			})
		},
		// 加载成功后获得可创建Tab的nodes
		onLoadSuccess : function(node, data) {
			var treeNodes = queryMenutree.tree('getChildren');
			for (var i = 0; i < treeNodes.length; i++) {
				if (queryMenutree.tree('isLeaf', treeNodes[i].target)) {
					tabChooses.push(treeNodes[i]);
				}
			}
		},
	});
	viewedProfTree.tree({
		url : '/TrainingProgramManager/getCategories.do',
		method : 'POST',
		cache : false,
		queryParams : {
			viewedMajorId : majorId
		},
		onClick : function(node) {
			if (dataTab.tabs('exists', node.text)) {
				dataTab.tabs('select', node.text);
				return;
			}
			// 判断专业选修课选项卡是否存在
			var tab = null;
			var nodes = viewedProfTree.tree('getRoots');
			for (var i = 0; i < nodes.length; i++) {
				tab = dataTab.tabs('getTab', nodes[i].text);
				if (tab != null) {
					dataTab.tabs('select', tab.text);
					break;
				}
			}
			// 存在且选择了不同模块则更新，不存在则添加选项卡
			if (tab != null) {
				// 防止更新时刷新页面而导致的dialog的bug
				tab.panel('options').href = null;
				// 更新标签
				dataTab.tabs('update', {
					tab : tab,
					options : {
						title : node.text,
					}
				})
				dataTab.tabs('select', node.text);
			} else {
				dataTab.tabs('add', {
					title : node.text,
					closable : true,
					href : '/TrainingProgramManager/fixTab.html',
					queryParams : {
						tab : 'adminView/viewedProfPrograms'
					},
				});
			}
			// 表格数据更新
			loadViewedProfData(node.id);
		},
	});
	$('#optTree').tree({
		onClick : function(node) {
			if (dataTab.tabs('exists', node.text)) {
				dataTab.tabs('select', node.text);
				return;
			}
			dataTab.tabs('add', {
				title : node.text,
				closable : true,
				href : '/TrainingProgramManager/statisticDetails.html',
			});
		}
	})
})
function loadViewedProfData(viewedCateId) {
	$.ajax({
		url : '/TrainingProgramManager/findprofPrograms.do',
		type : 'POST',
		data : {
			viewedCateId : viewedCateId,
		},
		success : function(rs) {
			$('#viewedProfDg').datagrid('loadData', rs);
		}
	})
	console.info(viewedCateId)
}