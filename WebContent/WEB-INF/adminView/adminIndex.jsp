<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="img/bee_favicon.ico" type="image/x-icon" />
<title>系统数据维护</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/adminView/adminIndex.js"></script>
</head>
<body class="easyui-layout">
	<!-- 北侧系统标题栏-->
	<div data-options="region:'north',split:true,collapsible:false"
		style="height: 80px; text-align: center; background: #33cccc">
		<h1>九 江 学 院 培 养 方 案 信 息 后 台 管 理</h1>
	</div>
	<!-- 西侧分类导航栏-->
	<div data-options="region:'west',title:'导航栏',split:true"
		style="width: 177px;">
		<div id="eaccordion" class="easyui-accordion"
			data-options="fit: true, border: false">
			<div title="主要课程" data-options="selected:true"
				style="overflow: auto; padding: 10px;">
				<ul id="gerneraletree" class="easyui-tree">
					<li id="adminView/adminProject">课程库信息</li>
					<li id="adminView/permissionSettings">用户权限</li>
					<li id="adminView/adviceSettings">建议指标设置</li>
				</ul>
			</div>
			<div title="预览专业方案" style="padding: 10px;">
				<!-- 动态模块树 -->
				<ul id="querableMajorTree"></ul>
			</div>
		</div>
	</div>
	<!-- 中央数据表格及操作区-->
	<div data-options="region:'center',title:'信息管理'"
		style="padding: 5px; background: #eee;">
		<!-- tab面板子容器-->
		<div id="etab" class="easyui-tabs" data-options="fit:true">
			<!--这里需要改成动态添加tab -->
			<div title="欢迎回来"
				data-options="href:'/TrainingProgramManager/fixTab.do?tab=welcome',closable:true">
			</div>
		</div>
	</div>
	<div data-options="region:'south'"
		style="padding: 5px; text-align: center">
		<span style="font-family: Arial;"> &#169;</span> JJU
		www.pharaoh1995.cn
	</div>
	<!-- 放在这里延缓加载带来的延迟 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/generaldatagrids.js"></script>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</body>
</html>