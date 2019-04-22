<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
			<tr>
				<td>比赛名称:</td>
				<td><input class="easyui-textbox" type="text" name="matchName" data-options="required:true" style="width: 280px;"></input></td>
			</tr>
	        <tr>
	            <td>选择比赛级别:</td>
				<td>
					<input type="text" id="className" class="easyui-combobox" name="matchRankId"
						   data-options="valueField:'matchRankId',textField:'rankName',url:'match/rank/selectAll',prompt: '请选择比赛级别',required:true,editable:false" />
				</td>
	        </tr>
	        <tr>
	            <td>比赛官方网址:</td>
	            <td><input type="text" id="matchWebsite" class="easyui-validatebox textbox" name="matchWebsite" data-options="" style="width: 280px; height: 20px"></input>
					<nobr id="isMatchWebsite" style="color: red"></nobr></td>

	        </tr>
	        <tr>
	            <td>面向人群:</td>
	            <td><input class="easyui-combobox" type="text" name="matchOrientedId"  data-options="valueField:'orientedId',
	             			textField:'orientedName',url:'match/oriented/selectAll',prompt: '请选择面向人群',required:true,editable:false" />

	            </td>
	        </tr>
	        <tr>
	            <td>报名开始时间:</td>
	            <td><input class="easyui-datebox" name="matchSignUpStartTime" data-options="required:true" /></td>
	        </tr>
			<tr>
				<td>报名截止时间:</td>
				<td><input class="easyui-datebox" name="matchSignUpEndTime" data-options="required:true" /></td>
			</tr>
	        <tr>
	            <td>最大参赛人数/团队数:</td>
	            <td>
	                <input class="easyui-numberbox" type="text" name="matchSignUpMaxNum" data-options="min:1,max:99999999,precision:0" />
	            </td>
	        </tr>
			<tr>
				<td>比赛开始时间:</td>
				<td><input class="easyui-datebox" name="matchStartTime" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>比赛截止时间:</td>
				<td><input class="easyui-datebox" name="matchEndTime" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>比赛地址:</td>
				<td>
					<input class="easyui-textbox" type="text" name="matchAddress" style="width: 500px" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<td>选择参赛形式:</td>
				<td>
					<input type="text" id="matchForm" class="easyui-combobox" name="matchForm"
						   data-options="valueField:'matchForm',textField:'matchFormName',url:'match/info/select/form',prompt: '请选择参赛形式',required:true,editable:false" />
					<nobr hidden="hidden" id="matchTeamNum">
						&nbsp;&nbsp;团队人数限制:<input class="easyui-textbox" type="text" name="matchTeamNum"  data-options="" />
					</nobr>
				</td>

			</tr>
	        <tr>
	            <td>比赛宣传海报:</td>
	            <td>
	            	 <input type="button"  id="onePicUpload" class="easyui-linkbutton picFileUpload" value="上传图片"></input>
	                 <input type="hidden" name="matchPosterUrl" id="matchPosterUrl"/>
	            </td>
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
	var FILE = {
        kingEditorParams : {
            //指定上传文件参数名称
            filePostName  : "uploadFile",
            //指定上传文件请求的url。
            uploadJson : 'match/file/image/upload',
            //上传类型，分别为image、flash、media、file
            dir : "image",
        }
	}
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		if (!isOk){
            $.messager.alert('提示','表单填写有误!');
            return ;
        }
		// alert(JSON.stringify($("#itemAddForm").serializeJSON()));
		var da = JSON.stringify($("#itemAddForm").serializeJSON());
		$.ajax({
			type : 'post',
			url : 'match/info/add',
			data : da,
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function (data) {
                if(data.code == 200){
                    $.messager.alert('提示','新增比赛成功!');
                }
            }
		})
		// $.post("match/info/add",$("#itemAddForm").serialize(), function(data){
		// 	if(data.code == 200){
		// 		$.messager.alert('提示','新增商品成功!');
		// 	}
		// },"application/json");
	}
	/* 清空表单 */
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}


	$(document).ready(function () {
	    $('#matchForm').combobox({
			onSelect : function () {
				var f = $('#matchForm').combobox('getValue');
				if (f != 1){
					$('#matchTeamNum').show();
				}else {
                    $('#matchTeamNum').hide();
				}
            }
		})
	    /* 网址校验 失去焦点 */
		$('#matchWebsite').blur(function () {
            var reg = /^((ht|f)tps?):\/\/[\w\-]+(\.[\w\-]+)+([\w\-.,@?^=%&:\/~+#]*[\w\-@?^=%&\/~+#])?$/;
            var url = $('#matchWebsite').val();
            if (url != "" && !reg.test(url)) {
                $('#isMatchWebsite').text("请输入正确网址（包含协议）");
                isOk = false;
            }else {
                $('#isMatchWebsite').text("");
                isOk = true;
			}
        });
		/* 单文件上传 + 回显 点击事件 */
        $("#onePicUpload").click(function(){
            var _self = $(this);
            KindEditor.editor(FILE.kingEditorParams).loadPlugin('image', function() {
                this.plugin.imageDialog({
					//是否开启网络图片
                    showRemote : false,
					//回调函数
                    clickFn : function(url, title, width, height, border, align) {
                        var input = _self.siblings("input");
                        $("#matchPosterUrl").val(url);
                        input.parent().find("img").remove();
                        input.val(url);
                        input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
                        this.hideDialog();
                    }
                });
            });
        });
    })
</script>
