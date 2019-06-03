<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchOrientedList" title="面向人群列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'match/oriented/selectAll/page',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'orientedid',checkbox:true"></th>
            <th data-options="field:'orientedname',width:150">人群名称</th>
            <th data-options="field:'orientedinfo',width:350">人群说明</th>
        </tr>
    </thead>
</table>
<div id="editOrientedWindow" class="easyui-window" title="编辑人群" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-oriented-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="addOrientedWindow" class="easyui-window" title="添加人群" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-oriented-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getOrientedIds(){
    	var matchOrientedList = $("#matchOrientedList");
    	var sels = matchOrientedList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orientedid);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getOrientedNames(){
        var matchOrientedList = $("#matchOrientedList");
        var sels = matchOrientedList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].orientedname);
        }
        names = names.join(",");
        return names;
    }

    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getOrientedIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一项才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一项!');
        		return ;
        	}
        	$("#editOrientedWindow").window({
        		onLoad :function(){
        			// 取出被选中数据
                    var data = $("#matchOrientedList").datagrid("getSelections")[0];
                    // 为表单提供数据
        			$("#matchOrientedEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },'-',{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getOrientedIds();
        	var names = getOrientedNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中记录!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除 : ['+ names +'] 吗？',function(r){
        	    if (r){
        	    	var params = {"orientedIds":ids};
                	$.ajax({
                        method : 'get',
                        data : params,
                        url : 'match/oriented/delete',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','删除成功!');
                                $('#matchOrientedList').datagrid('reload');
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
            $("#addOrientedWindow").window().window("open");
        }
    }]
    $(document).ready(function () {

    })
</script>