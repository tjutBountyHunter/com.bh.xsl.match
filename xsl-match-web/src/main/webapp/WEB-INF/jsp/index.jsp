<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宜立方商城后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/e3.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
    <!-- 头部标题 -->
	<div data-options="region:'north',border:false" style="height:60px; padding:5px; background:#F3F3F3">
	<span class="northTitle">后台管理系统</span>
	<span class="loginInfo">登录用户：admin&nbsp;&nbsp;姓名：管理员&nbsp;&nbsp;角色：系统管理员</span>
	</div>
	<div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
		<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">"
         	<li>
         		<span>比赛管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'match-add'}">添加比赛</li>
	         		<li data-options="attributes:{'url':'match-list'}">比赛管理</li>
	         		<li data-options="attributes:{'url':'match-rank-list'}">比赛等级管理</li>
					<li data-options="attributes:{'url':'match-oriented-list'}">比赛人群管理</li>
					<li data-options="attributes:{'url':'match-reward-rank-list'}">奖励等级管理</li>
					<li data-options="attributes:{'url':'match-reward-list-index'}">奖励管理</li>
					<li data-options="attributes:{'url':'match-type-list'}">比赛类型管理</li>
	         	</ul>
         	</li>
         	<li>
         		<span>队伍管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'match-team-add'}">创建队伍</li>
					<li data-options="attributes:{'url':'match-team-list'}">队伍管理</li>
	         		<li data-options="attributes:{'url':'content'}">内容管理</li>
	         	</ul>
         	</li>
         	<li>
         		<span>索引库管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'index-item'}">solr索引库维护</li>
	         	</ul>
         	</li>
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	
		    </div>
		</div>
    </div>
    <!-- 页脚信息 -->
	<div data-options="region:'south',border:false" style="height:20px; background:#F3F3F3; padding:2px; vertical-align:middle;">
		<span id="sysVersion">系统版本：V1.0</span>
	    <span id="nowTime"></span>
	</div>
<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("close",node.text);
				}
                tabs.tabs('add',{
                    title:node.text,
                    href: node.attributes.url,
                    closable:true,
                    bodyCls:"content"
                });
			}
		}
	});
});
setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
</script>
</body>
</html>