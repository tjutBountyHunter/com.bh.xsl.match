<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="matchRankEditForm" class="itemForm" method="post">
		<table cellpadding="5">
			<input type="text" hidden="hidden" name="matchId">
			<tr>
				<td>ID:</td>
				<td><input class="easyui-textbox" type="text" name="matchRankId" data-options="readonly:true" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>级别名称:</td>
				<td>
					<input class="easyui-textbox" type="text" name="rankName" data-options="required:true" style="width: 280px;"></input>
				</td>
			</tr>
			<tr>
				<td>说明:</td>
				<td><input class="easyui-textbox" type="text" name="rankInfo" data-options="" style="width: 280px;"></input></td>
			</tr>
		</table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 50px"  onclick="clearForm()">重置</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 50px"  onclick="winClose()">取消</a>
	</div>
</div>
<script type="text/javascript">
    var itemAddEditor ;
    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#matchRankEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $.messager.confirm('确认','确定修改比赛吗？',function(r){
            if (r){
                var da = JSON.stringify($("#matchRankEditForm").serializeJSON());
                $.ajax({
                    type : 'post',
                    url : 'match/rank/edit',
                    data : da,
                    contentType : 'application/json; charset=utf-8',
                    dataType : 'json',
                    success : function (data) {
                        if(data.code == 200){
                            $.messager.alert('提示','修改等级成功!');
                            $('#editRankWindow').window('close');
                            $('#matchRankList').datagrid('reload');
                        }
                    }
                })
            }
        });

    }
    /* 清空表单 */
    function clearForm(){
        $('#matchRankEditForm').form('reset');
        itemAddEditor.html('');
    }

    /* 关闭页面 */
	function winClose(){
	    $('#editRankWindow').window('close');
	}

    $(document).ready(function () {

    })
</script>
