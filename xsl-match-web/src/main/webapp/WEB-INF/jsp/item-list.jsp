<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'match/info/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'matchId',checkbox:true"></th>
            <th data-options="field:'matchName',width:150">比赛名称</th>
            <th data-options="field:'matchWebsite',width:350">比赛官网</th>
            <th data-options="field:'matchForm',width:100,align:'center',formatter:E3.formatForm">参数形式</th>
            <th data-options="field:'matchState',width:80,align:'center',formatter:E3.formatMatchStatus">状态</th>
            <th data-options="field:'matchCreateTime',width:150,align:'center',formatter:E3.formatDateTime">创建日期</th>
            <th data-options="field:'matchRankId',width:100,align:'center',formatter:E3.formatRank">比赛等级</th>
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
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div>
    <button id="button" >buu</button>
</div>
<script>

    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
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
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	$("#itemEditWindow").window({
        		onLoad :function(){
        			//回显数据
                    var data = $("#itemList").datagrid("getSelections")[0];
        			// 毫秒 转 标准日期
                    data.matchSignUpStartTime = myformatter(new Date(data.matchSignUpStartTime));
                    data.matchSignUpEndTime = myformatter(new Date(data.matchSignUpEndTime));
                    data.matchStartTime = myformatter(new Date(data.matchStartTime));
                    data.matchEndTime = myformatter(new Date(data.matchEndTime));
        			$("#itemeEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            			if(data.status == 500){
            				$.messager.alert('提示','删除商品失败!');
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
    $(document).ready(function () {
        $('#hidden-matchSignUpStartTime').hide();
        $('#button').click(function () {
            var data = $("#itemList").datagrid("getSelections")[0];
            alert(data.matchId + "   " + data.matchState);
        })
    })
</script>