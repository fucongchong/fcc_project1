<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body background="../photo/bg2020.jpg">
<form method="post" action="GetRegisterWorker">
<H1 align="center"><font color="black">用户注册</font></H1>
<p align="center">
<font size="5">用户编号：</font>
<input type="text" name="uid">

<p align="center">
<font size="5">用户名：</font>
<input type="text" name="uname">

<p align="center">
<font size="5">用户密码：</font>
<input type="password" name="upwd">

<p align="center">
<font size="5">用户邮箱：</font>
<input type="text" name="uemail">

<p align="center">
<font size="5">用户手机：</font>
<input type="text" name="uphone">

<p align="center">
<font size="5">用户部门：</font>
<input type="text" name="udept">

<p align="center">
<font size="5">入职年份：</font>
<input type="text" name="udate">

<p align="center">
<font size="5">用户类型：</font>
<label><input name="utype" type="radio" value="专家" /><font size="4">专家 </font></label> 
<label><input name="utype" type="radio" value="工作人员" /><font size="4">工作人员</font></label> 
<br>
<br>
<p align="center">
 <input type="submit" style="height:50px; width:75px;" value="注册">  
  <label>&nbsp&nbsp&nbsp&nbsp&nbsp</label> 
 <input type="reset" style="height:50px; width:75px;" value="重置"></p>
</form>
</body>
</html>