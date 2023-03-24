<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="UTF-8">
  <title>搜素图片</title>
</head>
<body style="text-align:center">



<form action="GetSearchPic" method="post"> 
请选择一个搜素条件：<br /><br /> 
<label><input name="searchType" type="checkbox" value="poname" />监控点名称 </label> 
<input name="searchWord1" type="text">
<br>
<label><input name="searchType" type="checkbox" value="poid" />监控点ID </label> 
<input name="searchWord2" type="text">
<br>
<label><input name="searchType" type="checkbox" value="pdate" />截取时间</label> 
<input name="searchWord3" type="text">
<br>



<input type="submit" value="搜索">

</form> 




</body>
</html>