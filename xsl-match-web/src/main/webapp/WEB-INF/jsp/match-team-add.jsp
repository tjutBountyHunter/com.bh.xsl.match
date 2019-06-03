<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/jquery.serializejson.min.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="teamAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
			<tr>
				<td>队伍名称:</td>
				<td><input class="easyui-textbox" type="text" name="teamname" data-options="required:true" style="width: 280px;"></input></td>
			</tr>
	        <tr>
	            <td>选择比赛类型:</td>
				<td>
					<input type="text" id="matchType"
						   data-options="valueField:'matchtypeid',textField:'matchtypename',url:'match/type/selectAll/list',prompt: '请选择比赛类型',required:true,editable:false" />
				</td>
	        </tr>
			<tr id="match" >
				<td>选择比赛:</td>
				<td>
					<input type="text" id="chooseMatch" name="matchid"
						   data-options="valueField:'matchid',textField:'matchname',prompt: '请选择比赛',required:true,editable:false" />
				</td>
			</tr>
	        <tr>
	            <td>队长:</td>
	            <td><input type="text" id="userPhoneOrEmail" class="easyui-validatebox textbox"  data-options="required:true,missingMessage: '请输入邮箱或手机号'" style="width: 280px; height: 20px"></input>
					<nobr id="isMatchWebsite" style="color: red"></nobr></td>
	        </tr>
			<%-- 获取teamCreatorId--%>
			<tr id="xx-sss">
				<td> <input name="teamcreatorid" id="getTeamCreatorId"></input></td>
			</tr>
			<tr>
				<td>队伍简介:</td>
				<td><input class="easyui-textbox" type="text" name="teamsynopsis" data-options="" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>队伍口号:</td>
				<td><input class="easyui-textbox" type="text" name="teamslogan" data-options="" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>队伍图标:</td>
				<td>
					<input type="button"  id="onePicUpload" class="easyui-linkbutton picFileUpload" value="上传图片"></input>
					<input type="hidden" name="teamlogourl" id="teamLogoUrl"/>
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
            uploadJson : 'file/image/upload',
            //上传类型，分别为image、flash、media、file
            dir : "image",
        }
	}
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#teamAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		if (!isOk){
            $.messager.alert('提示','表单填写有误!');
            return ;
        }
		var da = JSON.stringify($("#teamAddForm").serializeJSON());
		$.ajax({
			type : 'post',
			url : 'match/team/add',
			data : da,
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function (data) {
                if(data.code == 200){
                    $.messager.alert('提示','新增比赛成功!');
                    clearForm();
                }
            }
		})
	}
	/* 清空表单 */
	function clearForm(){
		$('#teamAddForm').form('reset');
        $('#match').hide();
        $('#isMatchWebsite').text("");
		itemAddEditor.html('');
	}


	$(document).ready(function () {
	    /* 邮箱正则 */
        var checkEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        /* 手机号正则 */
        var checkPhone = /^1[3|4|5|7|8][0-9]{9}$/;

        $('#match').hide();
        $('#xx-sss').hide();
	    $('#matchType').combobox({
			onSelect : function () {
				var f = $('#matchType').combobox('getValue');
				if (f != "" && f != "请选择比赛" && f != null){
					$('#match').show();
					$('#chooseMatch').combobox({
						url: "match/info/select/matchType?matchTypeId=" + f
					})
				}else {
                    $('#match').hide();
				}
            }
		})
	    /* 网址校验 失去焦点 */
		$('#userPhoneOrEmail').blur(function () {
            var userId = $('#userPhoneOrEmail').val();
            var url;
            var data;
            if (checkEmail.test(userId)){
				url = 'user/select/email';
				data = {"email": userId};
			}else if (checkPhone.test(userId)){
                url = 'user/select/phone';
				data = {"phone":userId};
			}else {
                $('#isMatchWebsite').text("");
                if(userId != ""){
                    $('#isMatchWebsite').text("手机号或邮箱格式错误");
                    isOk = false;
				}
                return;
			}
            $.ajax({
				url : url,
				data: data,
				method : 'get',
                contentType : 'application/json; charset=utf-8',
                dataType : 'json',
				success : function (da) {
                    if (da.code == 200) {
                        $('#isMatchWebsite').css('color','#00e309')
                        $('#isMatchWebsite').text("正确！用户名:" + da.data.name);
                        $('#getTeamCreatorId').val(da.data.userid);
                        isOk = true;
                    }else {
                        $('#isMatchWebsite').text("用户不存在，请检查输入是否正确");
                        isOk = false;
                    }
                }
			})
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
                        $("#teamLogoUrl").val(url);
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
