<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="UTF-8">
  <title>报警状态统计</title>
</head>
<body style="text-align:center">

<jsp:useBean id="statisricsbean" type="com.po.StastisticsPo" scope="session" />



目前数据库中监控系统正情况：
<label><%=statisricsbean.getAstatusRight()%>次</label>
<hr>
目前数据库中监控系统误情况：
<label><%=statisricsbean.getAstatusWrong()%>次</label>
<hr>
目前数据库中监控系统漏情况：
<label><%=statisricsbean.getAstatusNull()%>次</label>

</body>
</html>