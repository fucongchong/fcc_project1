<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>选题管理</title>
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
	        title:'选题管理', 
	        iconCls:'icon-more',//图标 
	        border: true, 
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        method: "post",
	        url:"get_list?t="+new Date().getTime(),
	        idField:'topicID', 
	        singleSelect:false,//是否单选 
	        pagination:true,//分页控件 
	        rownumbers:true,//行号 
	        sortName:'topicID',
	        sortOrder:'DESC', 
	        remoteSort: false,
	        columns: [[  
				{field:'chk',checkbox: true,width:50},
				{field:'topicID',title:'主题ID',width:150, sortable: true},
 		        {field:'topicName',title:'主题名',width:150,
 		        formatter: function(value,row,index){		         
        return '<a style="color:blue" href="detailed?dataTopicID='+row.topicID+'">'+value+'</a>';
       
     }
 		        },    
 		        {field:'keyWord',title:'关键词',width:150},
 		        {field:'tn',title:'出题教师姓名',width:150},
 		        {field:'createTime',title:'创建时间',width:150},
 		        {field:'peopleNumber',title:'选题人数',width:150},
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
            		ids[i] = row.sno;
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
										$("#add_TopicID").textbox('setValue', "");
										$("#add_TopicName").textbox('setValue', "");
										$("#add_keyWord").textbox('setValue', "");
										$("#add_TN").textbox('setValue', "");
										$("#add_createTime").textbox('setValue', "");
										$("#add_peopleNumber").textbox('setValue', "");
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
				$("#add_TopicID").textbox('setValue', "");
				$("#add_Name").textbox('setValue', "");
				
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
	    			<td>主题ID:</td>
	    			<td>
	    				<input id="add_TopicID"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="TopicID" data-options="required:true, missingMessage:'请填写主题ID'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>主题名:</td>
	    			<td>
	    				<input id="add_TopicName"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="TopicName" data-options="required:true, missingMessage:'请填写主题名'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>关键词:</td>
	    			<td>
	    				<input id="add_keyWord"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="keyWord" data-options="required:true, missingMessage:'请填写关键词'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>出题教师姓名:</td>
	    			<td>
	    				<input id="add_TN"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="TN" data-options="required:true, missingMessage:'请填写出题教师姓名'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>创建时间:</td>
	    			<td>
	    				<input id="add_createTime"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="createTime" data-options="required:true, missingMessage:'请填写创建时间'"  />
	    			</td>
	    		</tr>
	    		<tr >
	    			<td>选题人数:</td>
	    			<td>
	    				<input id="add_peopleNumber"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="peopleNumber" data-options="required:true, missingMessage:'请填写选题人数'"  />
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