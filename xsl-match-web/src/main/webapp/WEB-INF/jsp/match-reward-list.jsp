<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="getUrlPara">
    <input hidden="hidden" id="getMatchId"  type="text"  name="matchid">
    比赛名称：<input  class="easyui-textbox"  type="text"  name="matchname" data-options="readonly:true">
</form>
<table  id="matchRewardList" title="比赛奖励列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'rewardid',checkbox:true"></th>
            <th data-options="field:'rewardcontent',width:350">奖励内容</th>
            <th data-options="field:'rewardrankid',width:100,align:'center',formatter:E3.formatRewardRank">奖励等级</th>
            <th data-options="field:'contentquota',width:100">奖励数量</th>
            <th data-options="field:'rewardcreatetime',width:150,align:'center',formatter:E3.formatDateTime">创建日期</th>
        </tr>
    </thead>
</table>
<div id="editRewardWindow" class="easyui-window" title="编辑奖励" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-reward-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="addRewardWindow" class="easyui-window" title="添加奖励" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-reward-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getRewardIds(){
    	var matchRewardList = $("#matchRewardList");
    	var sels = matchRewardList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].rewardid);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getRewardNames(){
        var matchRewardList = $("#matchRewardList");
        var sels = matchRewardList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].rewardcontent);
        }
        names = names.join(",");
        return names;
    }

    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getRewardIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一项才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一项!');
        		return ;
        	}
        	$("#editRewardWindow").window({
        		onLoad :function(){
        			// 取出被选中数据
                    var data = $("#matchRewardList").datagrid("getSelections")[0];
                    var matchId = $('#getMatchId').val();
                    // 动态的为对象添加属性
                    eval("data.matchId = '" + matchId + "'")
                    // 为表单提供数据
        			$("#matchRewardEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },'-',{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getRewardIds();
        	var names = getRewardNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中记录!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除奖励 : ['+ names +'] 吗？',function(r){
        	    if (r){
                    var matchId = $('#getMatchId').val();
        	    	var params = {"rewardIds":ids,"matchId":matchId};
                	$.ajax({
                        method : 'get',
                        data : params,
                        url : 'match/reward/delete',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','比赛奖励删除成功!');
                                $('#matchRewardList').datagrid('reload');
                            }
                        }
                    })
        	    }
        	});
        }
    },'-',{
        text:'新增',
        iconCls:'icon-add',
        handler:function() {
            var data = $('#getMatchId').val();
            data = {
                matchid : data
            }
            $("#addRewardWindow").window({
                onLoad : function () {
                    $('#matchRewardAddForm').form('load',data);
                }
            }).window("open");
        }
    }]

</script>