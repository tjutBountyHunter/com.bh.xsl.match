<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchRankList" title="比赛等级列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'match/rank/selectAll/page',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'matchrankid',checkbox:true"></th>
            <th data-options="field:'rankname',width:150">等级名称</th>
            <th data-options="field:'rankinfo',width:350">等级说明</th>
        </tr>
    </thead>
</table>
<div id="editRankWindow" class="easyui-window" title="编辑等级" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-rank-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="addRankWindow" class="easyui-window" title="添加等级" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-rank-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getRankIds(){
    	var matchRankList = $("#matchRankList");
    	var sels = matchRankList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].matchrankid);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getRankNames(){
        var matchRankList = $("#matchRankList");
        var sels = matchRankList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].rankname);
        }
        names = names.join(",");
        return names;
    }

    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getRankIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一项才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一项!');
        		return ;
        	}
        	$("#editRankWindow").window({
        		onLoad :function(){
        			// 取出被选中数据
                    var data = $("#matchRankList").datagrid("getSelections")[0];
                    // 为表单提供数据
        			$("#matchRankEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },'-',{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getRankIds();
        	var names = getRankNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中记录!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除比赛等级 : ['+ names +'] 吗？',function(r){
                var params = {"matchRankIds":ids};
                $.ajax({
                    method : 'get',
                    data : params,
                    url : 'match/rank/delete',
                    contentType : 'application/json; charset=utf-8',
                    dataType : 'json',
                    success : function (data) {
                        if (data.code == 200){
                            $.messager.alert('提示','比赛等级删除成功!');
                            $('#matchRankList').datagrid('reload');
                        }
                    }
                })
        	});
        }
    },'-',{
        text:'新增',
        iconCls:'icon-add',
        handler:function() {
            $("#addRankWindow").window().window("open");
        }
    }]
    $(document).ready(function () {

    })
</script>