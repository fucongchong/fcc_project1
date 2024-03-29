<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>视频信息</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
	<script type="text/javascript">
	$(function() {	
		var table;
		
		//datagrid初始化 
	    $('#dataList').datagrid({ 
	        title:'视频信息', 
	        iconCls:'icon-more',//图标 
	        border: true, 
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        method: "post",
	        url:"get_piclist?t="+new Date().getTime(),
	        idField:'pid', 
	        singleSelect:false,//是否单选 
	        pagination:true,//分页控件 
	        rownumbers:true,//行号 
	        sortName:'pid',
	        sortOrder:'DESC', 
	        remoteSort: false,
	        columns: [[  
				{field:'chk',checkbox: true,width:50},
				{field:'pid',title:'图片编号',width:150, sortable: true},
 		        {field:'pname',title:'图片名称',width:150},    
 		        {field:'presolution',title:'图片分辨率',width:150},
 		        {field:'pdaddress',title:'图片缩略图',width:150},
 		        {field:'paddress',title:'图片地址',width:150},
 		        {field:'ptype',title:'图片类型',width:150},    
 		        {field:'pdate',title:'图片截取时间',width:150},
 		        {field:'poid',title:'图片来源监控点编号',width:150},
 		        {field:'puid',title:'值班人员编号',width:150},		
 		        {field:'pcmethod',title:'图片截取方式',width:150},        
	 		]], 
	        toolbar: "#toolbar"
	    }); 
	    //设置分页控件 
	    var p = $('#dataList').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [10,20,30,50,100],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    }); 
	    //设置工具类按钮
	    $("#add").click(function(){
	    	table = $("#addTable");
	    	$("#addDialog").dialog("open");
	    });
	    //查看课程详情
	    $("#edit").click(function(){
	    	table = $("#editTable");
	    	var selectRows = $("#dataList").datagrid("getSelections");
        	if(selectRows.length != 1){
            	$.messager.alert("消息提醒", "请选择一条数据进行操作!", "warning");
            } else{
		    	$("#editDialog").dialog("open");
            }
	    });
	    //删除
	    $("#delete").click(function(){
	    	var selectRows = $("#dataList").datagrid("getSelections");
        	var selectLength = selectRows.length;
        	if(selectLength == 0){
            	$.messager.alert("消息提醒", "请选择数据进行删除!", "warning");
            } else{
            	var ids = [];
            	$(selectRows).each(function(i, row){
            		ids[i] = row.pid;
            	});
            	$.messager.confirm("消息提醒", "您确定要删除吗？", function(r){
            		if(r){
            			$.ajax({
							type: "post",
							url: "delete",
							data: {ids: ids},
							dataType:'json',
							success: function(data){
								if(data.type == "success"){
									$.messager.alert("消息提醒","删除成功!","info");
									//刷新表格
									$("#dataList").datagrid("reload");
									$("#dataList").datagrid("uncheckAll");
								} else{
									$.messager.alert("消息提醒",data.msg,"warning");
									return;
								}
							}
						});
            		}
            	});
            }
	    });
	    
	  	//设置添加窗口
	    $("#addDialog").dialog({
	    	title: "添加年级",
	    	width: 450,
	    	height: 350,
	    	iconCls: "icon-add",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	buttons: [
	    		{
					text:'添加',
					plain: true,
					iconCls:'icon-user_add',
					handler:function(){
						var validate = $("#addForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{
							var data = $("#addForm").serialize();
							$.ajax({
								type: "post",
								url: "add",
								data: data,
								dataType:'json',
								success: function(data){
									if(data.type == "success"){
										$.messager.alert("消息提醒","添加成功!","info");
										//关闭窗口
										$("#addDialog").dialog("close");
										//清空原表格数据
										$("#add_aid").textbox('setValue', "");
										$("#add_adate").textbox('setValue', "");
										$("#add_ax").textbox('setValue', "");
										$("#add_ay").textbox('setValue', "");
										$("#add_astatus").textbox('setValue', "");
										$("#add_apoid").textbox('setValue', "");
										$("#add_aangle").textbox('setValue', "");
										$("#add_auid").textbox('setValue', "");
										$("#add_aeid").textbox('setValue', "");
										$("#add_aemessage").textbox('setValue', "");
							  			$('#dataList').datagrid("reload");
										
									} else{
										$.messager.alert("消息提醒",data.msg,"warning");
										return;
									}
								}
							});
						}
					}
				},
			],
			onClose: function(){
				$("#add_aid").textbox('setValue', "");
				$("#add_adate").textbox('setValue', "");
				
			}
	    });
	  	
	  	//编辑
	  	$("#editDialog").dialog({
	  		title: "编辑",
	    	width: 450,
	    	height: 350,
	    	iconCls: "icon-edit",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	buttons: [
	    		{
					text:'提交',
					plain: true,
					iconCls:'icon-edit',
					handler:function(){
						var validate = $("#editForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{
							
							var data = $("#editForm").serialize();
							
							$.ajax({
								type: "post",
								url: "edit",
								data: data,
								dataType:'json',
								success: function(data){
									if(data.type == "success"){
										$.messager.alert("消息提醒","修改成功!","info");
										//关闭窗口
										$("#editDialog").dialog("close");
										
										//重新刷新页面数据
							  			$('#dataList').datagrid("reload");
							  			$('#dataList').datagrid("uncheckAll");
										
									} else{
										$.messager.alert("消息提醒",data.msg,"warning");
										return;
									}
								}
							});
						}
					}
				},
			],
			onBeforeOpen: function(){
				var selectRow = $("#dataList").datagrid("getSelected");
				//设置值
				$("#edit-sno").val(selectRow.sno);
				$("#edit_sn").textbox('setValue', selectRow.sn);
				$("#edit_gender").textbox('setValue', selectRow.gender);
				$("#edit_dept").textbox('setValue', selectRow.dept);
				$("#edit_clas").textbox('setValue', selectRow.clas);
			}
	    });
	   	
	  	//搜索按钮
	  	$("#search-btn").click(function(){
	  		$('#dataList').datagrid('reload',{
	  			name:$("#search-name").textbox('getValue')
	  		});
	  	});
	});
	</script>
</head>
<body>
	<!-- 数据列表 -->
	<table id="dataList" cellspacing="0" cellpadding="0"> 
	    
	</table> 
	<!-- 工具栏 -->
	<div id="toolbar">
		
		<div style="float: left;"><a id="add" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		<div style="float: left;"><a id="edit" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		
		<div>
			
			<a id="delete" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-some-delete',plain:true">删除</a>
			
			年级名：<input id="search-name" class="easyui-textbox" />
			<a id="search-btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>
	</div>
	
	<!-- 添加窗口 -->
	<div id="addDialog" style="padding: 10px;">  
   		<form id="addForm" method="post">
	    	<table id="addTable" cellpadding="8">
	    		<tr >
	    			<td>报警记录编号:</td>
	    			<td>
	    				<input id="add_aid"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="aid" data-options="required:true, missingMessage:'请填写报警记录编号'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>报警时间:</td>
	    			<td>
	    				<input id="add_adate"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="adate" data-options="required:true, missingMessage:'请填写姓名'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>火点横轴坐标:</td>
	    			<td>
	    				<input id="add_ax"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="ax" data-options="required:true, missingMessage:'请填写性别'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>火点纵轴坐标:</td>
	    			<td>
	    				<input id="add_ay"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="ay" data-options="required:true, missingMessage:'请填写专业'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>状态:</td>
	    			<td>
	    				<input id="add_astatus"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="astatus" data-options="required:true, missingMessage:'请填写班级'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>产生报警的监控点ID:</td>
	    			<td>
	    				<input id="add_apoid"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="apoid" data-options="required:true, missingMessage:'请填写专业'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>监控点旋转角度:</td>
	    			<td>
	    				<input id="add_aangle"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="aangle" data-options="required:true, missingMessage:'请填写班级'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>巡值员工编号:</td>
	    			<td>
	    				<input id="add_auid"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="auid" data-options="required:true, missingMessage:'请填写班级'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>用户编号:</td>
	    			<td>
	    				<input id="add_aeid"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="aeid" data-options="required:true, missingMessage:'请填写专业'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>专家留言:</td>
	    			<td>
	    				<input id="add_aemessage"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="aemessage" data-options="required:true, missingMessage:'请填写班级'"  />
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	</div>
	
	
	<!-- 编辑 -->
	<div id="editDialog" style="padding: 10px">
    	<form id="editForm" method="post">
    		<input type="hidden" name="SNo" id="edit-sno">
	    	<table id="editTable" border=0 cellpadding="8" >
	    		<tr >
	    			<td>姓名:</td>
	    			<td>
	    				<input id="edit_sn"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="SN" data-options="required:true, missingMessage:'请填写姓名'"  />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><input id="edit_gender" style="width: 256px; height: 30px;" class="easyui-textbox" type="text" name="gender" data-options="required:true"  /></td>
	    		</tr>
	    		<tr>
	    			<td>专业:</td>
	    			<td><input id="edit_dept" style="width: 256px; height: 30px;" class="easyui-textbox" type="text" name="Dept" data-options="required:true"  /></td>
	    		</tr>
	            <tr>
	    			<td>班级:</td>
	    			<td><input id="edit_clas" style="width: 256px; height: 30px;" class="easyui-textbox" type="text" name="Clas" data-options="required:true"  /></td>
	    		</tr>
	    	</table>
	    </form>
	</div>
	
	
</body>
</html>