<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="matchRankAddForm" class="itemForm" method="post">
		<table cellpadding="5">
			<input type="text" hidden="hidden" name="matchid">
			<%--<tr>--%>
				<%--<td>ID:</td>--%>
				<%--<td><input class="easyui-textbox" type="text" name="matchRankId" data-options="readonly:true" style="width: 280px;"></input></td>--%>
			<%--</tr>--%>
			<tr>
				<td>级别名称:</td>
				<td>
					<input class="easyui-textbox" type="text" name="rankname" data-options="required:true" style="width: 280px;"></input>
				</td>
			</tr>
			<tr>
				<td>说明:</td>
				<td><input class="easyui-textbox" type="text" name="rankinfo" data-options="" style="width: 280px;"></input></td>
			</tr>
		</table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" style="width: 50px" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" style="width: 50px"  onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#matchRankAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		var da = JSON.stringify($("#matchRankAddForm").serializeJSON());
		$.ajax({
			type : 'post',
			url : 'match/oriented/add',
			data : da,
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function (data) {
                if(data.code == 200){
                    $.messager.alert('提示','新增等级成功!');
                    $('#addRankWindow').window('close');
                    $('#matchRankList').datagrid('reload');
                }
            }
		})
	}
	/* 清空表单 */
	function clearForm(){
		$('#matchRankAddForm').form('reset');
		itemAddEditor.html('');
	}


</script>
