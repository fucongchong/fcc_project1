<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>用户搜索结果</title>
</head>
<body style="text-align:center">

<jsp:useBean id="userDet" type="com.entity.UserDetail" scope="session" />

<table align="center" border="1">
<tr>
<th>用户编号</th>
<th>用户名</th>
<th>用户邮箱</th>
<th>用户手机</th>
<th>用户部门</th>
<th>入职年份</th>
<th>用户类型</th>
</tr>
<tr>
<th><%=userDet.getUid() %></th>
<th><%=userDet.getUname() %></th>
<th><%=userDet.getUemail() %></th>
<th><%=userDet.getUphone() %></th>
<th><%=userDet.getUdept() %></th>
<th><%=userDet.getUdate() %></th>
<th><%=userDet.getUtype() %></th>
</tr>
</table>

</body>
</html>