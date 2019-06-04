<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div style="padding:10px 10px 10px 10px">
	<form id="teamAddTag" class="itemForm" method="post">
	    <table cellpadding="5">
			<tr>
				<td>标签名称:</td>
				<td><input id="tagName" class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
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
	var isOk = true;
	//交表提单
	function submitForm(){
		//有效性验证
		if(!$('#teamAddTag').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		if (!isOk){
            $.messager.alert('提示','表单填写有误!');
            return ;
        }
		var tagName = $("#tagName").val();
		// data = JSON.stringify(data);
		// alert(data)
		$.ajax({
			type : 'post',
			url : 'tag/user/add',
			data : {'tagName':tagName},
			scriptCharset: 'utf-8',
			success : function (data) {
				if(data.code == 200){
					$.messager.alert('提示','新增比赛成功!');
					$('#addTagWindow').window('close');
					$('#matchTagList').datagrid('reload');
				}
			}
		})
	}
	/* 清空表单 */
	function clearForm(){
		$('#teamAddForm').form('reset');
		itemAddEditor.html('');
	}

</script>
