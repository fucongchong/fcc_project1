<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="UTF-8">
  <title>火灾判断</title>
</head>
<body>

<jsp:useBean id="picbean" type="com.entity.Picture" scope="session" />

<!--从数据库将视频的地址传过来  -->



<ul>
<%
for(int i=0;i<picbean.getPicArray().size();i++)
{
 %>
<li>
  <p></p> 
  <img src="../pic/<%=picbean.getPicArray().get(i).getPaddress() %>" width="500" height="360" alt="场部-绿叶-下午-A点-5个饼1" />
</li>
<hr>
<%} %>
</ul>

</body>
</html>