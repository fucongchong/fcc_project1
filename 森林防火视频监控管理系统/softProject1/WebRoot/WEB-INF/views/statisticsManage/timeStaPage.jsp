<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="UTF-8">
  <title>报警时间统计</title>
</head>
<body style="text-align:center">

<jsp:useBean id="statisricsbean" type="com.po.StastisticsPo" scope="session" />




<ul>
<%
for(int i=0;i<statisricsbean.getStaArray().size();i++)
{
 %>
<li>
  <p></p> 
  <label><%=statisricsbean.getStaArray().get(i).getAdate() %></label>
</li>
<hr>
<%} %>
</ul>

</body>
</html>