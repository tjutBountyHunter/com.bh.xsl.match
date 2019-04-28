<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchTeamList" title="比赛等级列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'match/team/selectAll/page',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'teamId',checkbox:true"></th>
            <th data-options="field:'teamName',width:150">队伍名称</th>
            <th data-options="field:'matchId',width:150,align:'center',formatter:E3.formatMatch">参加的比赛</th>
            <th data-options="field:'teamSlogan',width:350">口号</th>
            <th data-options="field:'teamCreateTime',width:150,align:'center',formatter:E3.formatDateTime">创建日期</th>
        </tr>
    </thead>
</table>
<div id="editTypeWindow" class="easyui-window" title="编辑等级" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-type-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="addTypeWindow" class="easyui-window" title="添加等级" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-type-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getTypeIds(){
    	var matchTeamList = $("#matchTeamList");
    	var sels = matchTeamList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].matchTypeId);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getTypeNames(){
        var matchTeamList = $("#matchTeamList");
        var sels = matchTeamList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].matchTypeName);
        }
        names = names.join(",");
        return names;
    }

    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getTypeIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一项才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一项!');
        		return ;
        	}
        	$("#editTypeWindow").window({
        		onLoad :function(){
        			// 取出被选中数据
                    var data = $("#matchTeamList").datagrid("getSelections")[0];
                    // 为表单提供数据
        			$("#matchTypeEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },'-',{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getTypeIds();
        	var names = getTypeNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中记录!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除比赛等级 : ['+ names +'] 吗？',function(r){
        	    if (r){
        	    	var params = {"matchTypeIds":ids};
                	$.ajax({
                        method : 'get',
                        data : params,
                        url : 'match/type/delete',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','删除成功!');
                                $('#matchTeamList').datagrid('reload');
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
            $("#addTypeWindow").window().window("open");
        }
    }]
    $(document).ready(function () {

    })
</script>