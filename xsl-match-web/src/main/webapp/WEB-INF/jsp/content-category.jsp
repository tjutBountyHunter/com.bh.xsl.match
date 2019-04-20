<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	 <ul id="contentCategory" class="easyui-tree">
    </ul>
</div>
<div id="contentCategoryMenu" class="easyui-menu" style="width:120px;" data-options="onClick:menuHandler">
    <div data-options="iconCls:'icon-add',name:'add'">添加</div>
    <div data-options="iconCls:'icon-remove',name:'rename'">重命名</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
</div>
<script type="text/javascript">
$(function(){
	$("#contentCategory").tree({
		url : '/content/category/list',
		animate: true,
		method : "GET",
		/* e事件信息对象，node触发事件的控件 ，右键事件*/
		onContextMenu: function(e,node){
            e.preventDefault();
            /* 选中触发事件的节点 */
            $(this).tree('select',node.target);
            /* 显示菜单，X,Y为坐标 */
            $('#contentCategoryMenu').menu('show',{
                left: e.pageX,
                top: e.pageY
            });
        },
        /* 编辑结束触发事件 ,node为光标离开节点的对象 */
        onAfterEdit : function(node){
        	var _tree = $(this);
        	if(node.id == 0){
        		// 新增节点
        		$.post("/content/category/create",{parentId:node.parentId,name:node.text},function(data){
        			if(data.status == 200){
        				_tree.tree("update",{
            				target : node.target,
            				id : data.data.id
            			});
        			}else{
        				$.messager.alert('提示','创建'+node.text+' 分类失败!');
        			}
        		});
        	}else{
        		$.post("/content/category/update",{id:node.id,name:node.text});
        	}
        }
	});
});
/* item为选中节点 */
function menuHandler(item){
	var tree = $("#contentCategory");
	/* 获取选中节点 */
	var node = tree.tree("getSelected");
	if(item.name === "add"){
		/* 在当前节点下新增一个节点 */
		tree.tree('append', {
            parent: (node?node.target:null),
            data: [{
                text: '新建分类',
                id : 0,
                parentId : node.id
            }]
        }); 
		/* 找到id为0的节点 */
		var _node = tree.tree('find',0);
		/* 将该节点设置为可编辑状态（target目标） */
		tree.tree("select",_node.target).tree('beginEdit',_node.target);
	}else if(item.name === "rename"){
		tree.tree('beginEdit',node.target);
	}else if(item.name === "delete"){
		$.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
			if(r){
				$.post("/content/category/delete",{id:node.id},function(data){
					if(data.status == 200)
					tree.tree("remove",node.target);
					else
						$.messager.confirm('错误','该节点不可删除，请将其子节点删除');
				});	
			}
		});
	}
}
</script>