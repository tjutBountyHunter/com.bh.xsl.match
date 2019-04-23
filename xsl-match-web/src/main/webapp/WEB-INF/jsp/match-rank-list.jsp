<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchRankList" title="比赛等级列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'match/rank/selectAll',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'matchRankId',checkbox:true"></th>
            <th data-options="field:'rankName',width:150">等级名称</th>
            <th data-options="field:'rankInfo',width:350">等级说明</th>
        </tr>
    </thead>
</table>
<div id="editRankWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-rank-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getSelectionsIds(){
    	var matchRankList = $("#matchRankList");
    	var sels = matchRankList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].matchRankId);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getSelectionsNames(){
        var matchRankList = $("#matchRankList");
        var sels = matchRankList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].rankName);
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
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
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
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	var names = getSelectionsNames();
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
                                $('#matchRankList').datagrid('reload');
                            }
                        }
                    })
        	    }
        	});
        }
    },'-',{
        text:'禁用比赛',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	var names = getSelectionsNames();
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
                                $('#matchRankList').datagrid('reload');
                            }
                        }
                    })
        	    }
        	});
        }
    }];
    $(document).ready(function () {

    })
</script>