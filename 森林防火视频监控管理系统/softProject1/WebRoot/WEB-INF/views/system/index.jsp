<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>森林防火视频监控管理系统 管理员后台</title>
    <link rel="shortcut icon" href="favicon.ico"/>
	<link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="../easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='../easyui/js/outlook2.js'> </script>
    <script type="text/javascript">
	 var _menus = {"menus":[			
						<c:if test="${userType == 1}">
						{"menuid":"1","icon":"","menuname":"用户管理",
							"menus":[
									{"menuid":"11","menuname":"审核注册","icon":"icon-user-student","url":"../userc/userWaitList"},
									{"menuid":"12","menuname":"查找用户","icon":"icon-user-student","url":"../userc/userFindList"},
									{"menuid":"13","menuname":"用户信息","icon":"icon-user-student","url":"../userc/userManageList"},
								]
						},
						{"menuid":"2","icon":"","menuname":"日志查询",
							"menus":[
									{"menuid":"21","menuname":"日志查询","icon":"icon-user-student","url":"../userc/loginfoList"},
								]
						},
						</c:if>
						<c:if test="${userType == 2}">				
						{"menuid":"3","icon":"","menuname":"火灾资源管理-视频管理",
							"menus":[							        
							        {"menuid":"31","menuname":"视频检索","icon":"icon-user-student","url":"../movieManage/searchMovie"},
								    {"menuid":"32","menuname":"视频在线播放","icon":"icon-user-student","url":"../movieManage/onlineMovie"},
								    {"menuid":"33","menuname":"视频下载","icon":"icon-user-student","url":"../movieManage/downloadMovie"},
								    {"menuid":"34","menuname":"批量删除视频","icon":"icon-user-student","url":"../movieManage/deleteMovie"},
								     ]    							
						},
						{"menuid":"4","icon":"","menuname":"火灾资源管理-图片管理",
							"menus":[							        
							        {"menuid":"41","menuname":"图片检索","icon":"icon-user-student","url":"../picManage/searchPic"},
								    {"menuid":"42","menuname":"图片在线查看","icon":"icon-user-student","url":"../picManage/onlinePic"},
								    {"menuid":"43","menuname":"图片下载","icon":"icon-user-student","url":"../picManage/downloadPic"},
								    {"menuid":"44","menuname":"删除图片","icon":"icon-user-student","url":"../picManage/deletePic"},
								     ]    							
						},
						{"menuid":"5","icon":"","menuname":"报警事件管理",
							"menus":[
									{"menuid":"51","menuname":"报警事件确认","icon":"icon-user-student","url":"../warningManage/affirmAlarm"},
									{"menuid":"52","menuname":"报警信息发送","icon":"icon-user-student","url":"../topic/list"},								
									{"menuid":"53","menuname":"查询未处理报警记录","icon":"icon-user-student","url":"../warningManage/notDealList"},
									{"menuid":"54","menuname":"查询已处理报警记录","icon":"icon-user-student","url":"../warningManage/hadDealedList"},									
									{"menuid":"55","menuname":"增加报警记录","icon":"icon-user-student","url":"../warningManage/addlist"},
								]
						},
						{"menuid":"6","icon":"","menuname":"火灾情况统计",
							"menus":[
									{"menuid":"61","menuname":"次数统计","icon":"icon-user-student","url":"../statistics/countStatistics"},
									{"menuid":"61","menuname":"状态统计","icon":"icon-user-student","url":"../statistics/statusStatistics"},
									{"menuid":"61","menuname":"时间统计","icon":"icon-user-student","url":"../statistics/timeStatistics"},
								]
						},
						{"menuid":"11","icon":"","menuname":"扑火人员定位",
							"menus":[
									{"menuid":"111","menuname":"扑火人员定位","icon":"icon-user-student","url":"../statistics/getlocation"},
									
								]
						},
						</c:if>
						<c:if test="${userType == 3}">				
						{"menuid":"7","icon":"","menuname":"火灾资源管理-视频管理",
							"menus":[							        
							        {"menuid":"71","menuname":"视频检索","icon":"icon-user-student","url":"../movieManage/searchMovie"},
								    {"menuid":"72","menuname":"视频在线播放","icon":"icon-user-student","url":"../movieManage/onlineMovie"},
								    {"menuid":"73","menuname":"视频下载","icon":"icon-user-student","url":"../movieManage/downloadMovie"},
								    {"menuid":"74","menuname":"批量删除视频","icon":"icon-user-student","url":"../movieManage/deleteMovie"},
								     ]    							
						},
						{"menuid":"8","icon":"","menuname":"火灾资源管理-图片管理",
							"menus":[							        
							        {"menuid":"81","menuname":"图片检索","icon":"icon-user-student","url":"../picManage/searchPic"},
								    {"menuid":"82","menuname":"图片在线查看","icon":"icon-user-student","url":"../picManage/onlinePic"},
								    {"menuid":"83","menuname":"图片下载","icon":"icon-user-student","url":"../picManage/downloadPic"},
								    {"menuid":"84","menuname":"删除图片","icon":"icon-user-student","url":"../picManage/deletePic"},
								     ]    							
						},
						{"menuid":"9","icon":"","menuname":"报警事件管理",
							"menus":[
									
									{"menuid":"91","menuname":"报警信息发送","icon":"icon-user-student","url":"../topic/list"},								
									{"menuid":"92","menuname":"查询未处理报警记录","icon":"icon-user-student","url":"../warningManage/notDealList"},
									{"menuid":"93","menuname":"查询已处理报警记录","icon":"icon-user-student","url":"../warningManage/hadDealedList"},									
									{"menuid":"94","menuname":"增加报警记录","icon":"icon-user-student","url":"../warningManage/addlist"},
								]
						},
						{"menuid":"10","icon":"","menuname":"火灾情况统计",
							"menus":[
									{"menuid":"101","menuname":"次数统计","icon":"icon-user-student","url":"../statistics/countStatistics"},
									{"menuid":"101","menuname":"状态统计","icon":"icon-user-student","url":"../statistics/statusStatistics"},
									{"menuid":"101","menuname":"时间统计","icon":"icon-user-student","url":"../statistics/timeStatistics"},
								]
						},
						</c:if>
						
				]};


    </script>
<jsp:useBean id="ptp" type="com.pojo.LoginTypePojo" scope="session"/>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background:  #7f99be;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        
        <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;"></span>您好&nbsp;&nbsp;&nbsp;<a href="login_out" id="loginOut">安全退出</a></span>                
        
        <span style="padding-left:10px; font-size: 16px; ">森林防火视频监控管理系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">计算机17-1班 邓卓宏 付聪冲 &copy; 陈佳丽 尚凌云 尹朦朦</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
	</div>
	
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<jsp:include page="welcome.jsp" />
		</div>
    </div>
	
</body>
</html>