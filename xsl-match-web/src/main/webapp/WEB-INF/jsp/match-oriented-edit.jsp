<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="matchOrientedEditForm" class="itemForm" method="post">
		<table cellpadding="5">
			<input type="text" hidden="hidden" name="orientedid">
			<tr>
				<td>人群名称:</td>
				<td>
					<input class="easyui-textbox" type="text" name="orientedname" data-options="required:true" style="width: 280px;"></input>
				</td>
			</tr>
			<tr>
				<td>说明:</td>
				<td><input class="easyui-textbox" type="text" name="orientedinfo" data-options="" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td><input  type="hidden" name="orientedstate"  style="width: 280px;"></input></td>
			</tr>
		</table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
		<%--<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 50px"  onclick="clearForm()">重置</a>--%>
		<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 50px"  onclick="winClose()">取消</a>
	</div>
</div>
<script type="text/javascript">
    var itemAddEditor ;
    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#matchOrientedEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $.messager.confirm('确认','确定修改吗？',function(r){
            if (r){
                var da = JSON.stringify($("#matchOrientedEditForm").serializeJSON());
                $.ajax({
                    type : 'post',
                    url : 'match/oriented/edit',
                    data : da,
                    contentType : 'application/json; charset=utf-8',
                    dataType : 'json',
                    success : function (data) {
                        if(data.code == 200){
                            $.messager.alert('提示','修改成功!');
                            winClose();
                            $('#matchOrientedList').datagrid('reload');
                        }
                    }
                })
            }
        });

    }
    /* 清空表单 */
    function clearForm(){
        $('#matchOrientedEditForm').form('reset');
        itemAddEditor.html('');
    }

    /* 关闭页面 */
	function winClose(){
	    $('#editOrientedWindow').window('close');
	}

    $(document).ready(function () {

    })
</script>
