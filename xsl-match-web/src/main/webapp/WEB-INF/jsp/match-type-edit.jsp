<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="matchTypeEditForm" class="itemForm" method="post">
		<table cellpadding="5">
			<tr>
				<td>类型ID:</td>
				<td><input id="getRewardMatchId" class="easyui-textbox" type="text" name="matchtypeid" data-options="readonly:true" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>类型名称:</td>
				<td>
					<input class="easyui-textbox" type="text" name="matchtypename" data-options="required:true" style="width: 280px;"></input>
				</td>
			</tr>
			<tr>
				<td>类型说明:</td>
				<td><input class="easyui-textbox" type="text" name="matchtypeinfo" data-options="required:true" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td><input type="hidden"  name="matchtypestate"  style="width: 280px;"></input></td>
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
		if(!$('#matchTypeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		var da = JSON.stringify($("#matchTypeEditForm").serializeJSON());
		$.ajax({
			type : 'post',
			url : 'match/type/edit',
			data : da,
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function (data) {
                if(data.code == 200){
                    $.messager.alert('提示','修改成功!');
                    $('#editTypeWindow').window('close');
                    $('#matchTypeList').datagrid('reload');
                }
            }
		})
	}
	/* 清空表单 */
	function clearForm(){
	    var id = $('#getRewardMatchId').val();
	    id = {
            matchTypeId : id
		}
		$('#matchTypeEditForm').form('reset');
		$('#matchTypeEditForm').form('load',id);
		// itemAddEditor.html('');
	}


</script>
