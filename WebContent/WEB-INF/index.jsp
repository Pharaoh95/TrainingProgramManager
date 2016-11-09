<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>九江学院培养方案管理</title>
<link rel="icon" href="img/bee_favicon.ico" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<!-- 引入自己写的jquery库以及自定义的js -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/mainframe.js"></script>
</head>
<body class="easyui-layout">
	<!-- 北侧系统标题栏-->
	<div data-options="region:'north',split:true,collapsible:false"
		style="height: 80px; text-align: center; background: #33cccc">
		<h1>九 江 学 院 培 养 方 案 信 息 管 理</h1>
	</div>
	<!-- 西侧分类导航栏-->
	<div data-options="region:'west',title:'导航栏',split:true"
		style="width: 177px;">
		<div id="eaccordion" class="easyui-accordion"
			data-options="fit: true, border: false">
			<div title="主要课程" data-options="selected:true"
				style="overflow: auto; padding: 10px;">
				<ul id="gerneraletree" class="easyui-tree">
					<li id="project" data-options="iconCls:'icon-search'">课程库查询</li>
					<li><span>综合教育</span>
						<ul>
							<li id="requiedProgram">必修课设置</li>
							<li id="optionedProgram">选修课设置</li>
						</ul></li>
					<li><span>专业教育</span>
						<ul>
							<li id="basicalProgram">专业基础课</li>
							<li id="profProgram">专业课</li>
						</ul></li>
					<li id="practiceProgram">实践教学</li>
				</ul>
			</div>
			<div title="  专业选修课" style="padding: 10px;">
				<!-- 动态模块树 -->
				<ul id="proftree"></ul>
				<!-- 添加模块选项 -->
				<ul id="addmodule" class="easyui-tree">
					<li id="addModule" data-options="iconCls:'icon-add'">添加模块</li>
					<li id="statisticDetails" data-options="iconCls:'icon-sum'">统计详情</li>
				</ul>
			</div>
			<div title="  账号管理" style="padding: 10px;">
				<ul id="roletree" class="easyui-tree">
					<li id="pwdSettings" data-options="iconCls:'icon-man'">密码修改</li>
					<li id="outputProgs" data-options="iconCls:'icon-print'">生成word</li>
					<li id="logout" data-options="iconCls:'icon-back'">退出系统</li>
				</ul>
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
	<!-- 右侧数据统计栏 -->
	<div
		data-options="region:'east',href:'/TrainingProgramManager/fixTab.do?tab=statistc',title:'统计栏'"
		style="width: 200px;"></div>
	<!-- 南侧授权说明 -->
	<div data-options="region:'south'"
		style="padding: 5px; text-align: center">
		<span style="font-family: Arial;"> &#169;</span> jju
		www.pharaoh1995.cn
	</div>
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