<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchList" title="比赛列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'match/info/page',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'matchid',checkbox:true"></th>
            <th data-options="field:'matchname',width:150">比赛名称</th>
            <th data-options="field:'matchrankid',width:100,align:'center',formatter:E3.formatRank">比赛等级</th>
            <th data-options="field:'matchtypeid',width:100,align:'center',formatter:E3.formatMatchType">比赛类型</th>
            <th data-options="field:'matchwebsite',width:350">比赛官网</th>
            <th data-options="field:'matchform',width:100,align:'center',formatter:E3.formatForm">参数形式</th>
            <th data-options="field:'matchstate',width:80,align:'center',formatter:E3.formatMatchStatus">状态</th>
            <th data-options="field:'matchcreatetime',width:150,align:'center',formatter:E3.formatDateTime">创建日期</th>
            <%-- 比赛信息的其余属性 --%>
            <%--<th id="hidden-matchSignUpStartTime" data-options="field:'matchSignUpStartTime',width:10,align:'center',formatter:E3.formatDate"></th>--%>
            <%--<th id="hidden-matchSignUpEndTime" data-options="field:'matchSignUpEndTime',width:10,align:'center',formatter:E3.formatDate"></th>--%>
            <%--<th id="hidden-matchSignUpMaxNum" data-options="field:'matchSignUpMaxNum',width:10"></th>--%>
            <%--<th id="hidden-matchStartTime" data-options="field:'matchStartTime',width:10,align:'center',formatter:E3.formatDate"></th>--%>
            <%--<th id="hidden-matchEndTime" data-options="field:'matchEndTime',width:10,align:'center',formatter:E3.formatDate"></th>--%>
            <%--<th id="hidden-matchAddress" data-options="field:'matchAddress',width:10"></th>--%>
            <%--<th id="hidden-matchSignUpEndTime" data-options="field:'matchSignUpEndTime',width:10"></th>--%>
            <%--<th id="hidden-matchPosterUrl" data-options="field:'matchPosterUrl',width:10"></th>--%>
        </tr>
    </thead>
</table>
<div id="matchEditWindow" class="easyui-window" title="编辑比赛信息" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="matchRewardEditWindow" class="easyui-window" title="管理比赛奖励" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-reward-list'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getMatchIds(){
    	var matchList = $("#matchList");
    	var sels = matchList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].matchid);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getMatchNames(){
        var matchList = $("#matchList");
        var sels = matchList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].matchname);
        }
        names = names.join(",");
        return names;
    }

    /* Date 数据格式化 yyyy-MM-dd */
    function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }


    var toolbar = [{
        text:'编辑比赛信息',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getMatchIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	$("#matchEditWindow").window({
        		onLoad :function(){
        			// 取出被选中数据
                    var data = $("#matchList").datagrid("getSelections")[0];
        			// 毫秒 转 标准日期
                    data.matchsignupstarttime = myformatter(new Date(data.matchsignupstarttime));
                    data.matchsignupendtime = myformatter(new Date(data.matchsignupendtime));
                    data.matchstarttime = myformatter(new Date(data.matchstarttime));
                    data.matchendtime = myformatter(new Date(data.matchendtime));
                    // 为表单提供数据
        			$("#matchEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getMatchIds();
        	var names = getMatchNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除比赛 : ['+ names +'] 吗？',function(r){
        	    if (r){
        	    	var params = {"matchIds":ids};
                	$.ajax({
                        method : 'get',
                        data : params,
                        url : 'match/info/delete',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','比赛删除成功!');
                                $('#matchList').datagrid('reload');
                            }
                        }
                    })
        	    }
        	});
        }
    },{
        text:'禁用比赛',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getMatchIds();
        	var names = getMatchNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定禁用比赛 '+ names +' 吗？',function(r){
        	    if (r){
                    var params = {"matchIds":ids};
                    $.ajax({
                        method : 'get',
                        data : params,
                        url : 'match/info/update/disableMatch',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','比赛禁用成功!');
                                $('#matchList').datagrid('reload');
                            }
                        }
                    })
        	    }
        	});
        }
    },'-',{
        text:'比赛奖励管理',
        iconCls:'icon-redo',
        handler:function(){
            var ids = getMatchIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个!');
                return ;
            }
            $("#matchRewardEditWindow").window({
                onLoad :function(){
                    var data = $("#matchList").datagrid("getSelections")[0];
                    $('#matchRewardList').datagrid({
                        url : 'match/reward/select/info',
                        method : 'get',
                        queryParams : {
                            matchId : data.matchid
                        }
                    })
                    // 为表单提供数据
                    $("#getUrlPara").form("load",data);
                }
            }).window("open");
        }
    }];
    $(document).ready(function () {

    })
</script>