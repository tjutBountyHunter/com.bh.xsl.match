<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="matchRewardAddForm" class="itemForm" method="post">
		<table cellpadding="5">
			<tr>
				<td>比赛ID:</td>
				<td><input id="getRewardMatchId" class="easyui-textbox" type="text" name="matchid" data-options="readonly:true" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>奖励内容:</td>
				<td>
					<input class="easyui-textbox" type="text" name="rewardcontent" data-options="required:true" style="width: 280px;"></input>
				</td>
			</tr>
			<tr>
				<td>奖励级别:</td>
				<td>
					<input type="text" id="className" class="easyui-combobox" name="rewardrankid"
						   data-options="valueField:'rewardrankid',textField:'rewardrankname',url:'match/reward/rank/selectAll',prompt: '请选择奖励级别',required:true,editable:false" />
				</td>
			</tr>
			<tr>
				<td>数量:</td>
				<td><input class="easyui-textbox" type="text" name="contentquota" data-options="required:true" style="width: 280px;"></input></td>
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
		if(!$('#matchRewardAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		var da = JSON.stringify($("#matchRewardAddForm").serializeJSON());
		$.ajax({
			type : 'post',
			url : 'match/reward/add',
			data : da,
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function (data) {
                if(data.code == 200){
                    $.messager.alert('提示','奖励添加成功!');
                    $('#addRewardWindow').window('close');
                    $('#matchRewardList').datagrid('reload');
                }
            }
		})
	}
	/* 清空表单 */
	function clearForm(){
	    var id = $('#getRewardMatchId').val();
	    id = {
            matchId : id
		}
		$('#matchRewardAddForm').form('reset');
		$('#matchRewardAddForm').form('load',id);
		// itemAddEditor.html('');
	}


</script>
