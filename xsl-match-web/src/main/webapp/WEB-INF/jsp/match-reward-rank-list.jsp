<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchRewardRankList" title="比赛奖励列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url : 'match/reward/rank/selectAll/page',method : 'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'rewardrankid',checkbox:true"></th>
            <th data-options="field:'rewardrankname',width:350">奖励级别</th>
            <th data-options="field:'rewardrankinfo',width:100">奖励级别说明</th>
        </tr>
    </thead>
</table>
<div id="addRewardRankWindow" class="easyui-window" title="添加奖励等级" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-reward-rank-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getRewardRankIds(){
    	var matchRewardRankList = $("#matchRewardRankList");
    	var sels = matchRewardRankList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].rewardrankid);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getRewardRankNames(){
        var matchRewardRankList = $("#matchRewardRankList");
        var sels = matchRewardRankList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].rewardrankname);
        }
        names = names.join(",");
        return names;
    }

    var toolbar = [{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getRewardRankIds();
        	var names = getRewardRankNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中记录!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除奖励 : ['+ names +'] 吗？',function(r){
        	    if (r){
        	    	var params = {"rewardRankIds":ids};
                	$.ajax({
                        method : 'get',
                        data : params,
                        url : 'match/reward/rank/delete',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','奖励等级删除成功!');
                                $('#matchRewardRankList').datagrid('reload');
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
            $("#addRewardRankWindow").window({}).window("open");
        }
    }]

</script>