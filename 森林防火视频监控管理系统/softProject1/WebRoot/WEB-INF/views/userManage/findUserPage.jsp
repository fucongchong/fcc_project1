<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="UTF-8">
  <title>查找一个用户</title>
</head>
<body style="text-align:center">



<form action="GetFindUser" method="post"> 
请输入用户编号查找用户：<br /><br /> 
<input name="findUID" type="text">
<br>




<input type="submit" value="查找">

</form> 




</body>
</html>