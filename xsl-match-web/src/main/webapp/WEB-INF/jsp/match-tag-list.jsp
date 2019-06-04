<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="matchTagList" title="标签列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'tag/get/tags/page',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'tagid',checkbox:true"></th>
            <th data-options="field:'name',width:150">标签名称</th>
            <th data-options="field:'state',width:150,align:'center',formatter:E3.formatTagStatus">标签状态</th>
            <th data-options="field:'createdate',width:150,align:'center',formatter:E3.formatDateTime">创建日期</th>
        </tr>
    </thead>
</table>
<div id="editTagWindow" class="easyui-window" title="编辑标签" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-tag-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="addTagWindow" class="easyui-window" title="添加标签" data-options="modal:true,closed:true,iconCls:'icon-save',href:'match-tag-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    /* 获取被选中数据的MatchId */
    function getTagIds(){
    	var matchTagList = $("#matchTagList");
    	var sels = matchTagList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].tagid);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    /* 获取被选中数据的MatchName */
    function getTagNames(){
        var matchTagList = $("#matchTagList");
        var sels = matchTagList.datagrid("getSelections");
        var names = [];
        for(var i in sels){
            names.push(sels[i].name);
        }
        names = names.join(",");
        return names;
    }

    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getTagIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一项才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一项!');
        		return ;
        	}
        	$("#editTagWindow").window({
        		onLoad :function(){
        			// 取出被选中数据
                    var data = $("#matchTagList").datagrid("getSelections")[0];
                    // 为表单提供数据
        			$("#matchTagEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },'-',{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getTagIds();
        	var names = getTagNames();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中记录!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除比赛等级 : ['+ names +'] 吗？',function(r){
        	    if (r){
        	    	var params = {"tagIds":ids};
                	$.ajax({
                        method : 'get',
                        data : params,
                        url : 'tag/remove/tags',
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        success : function (data) {
                            if (data.code == 200){
                                $.messager.alert('提示','删除成功!');
                                $('#matchTagList').datagrid('reload');
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
            $("#addTagWindow").window().window("open");
        }
    }]
    $(document).ready(function () {

    })
</script>