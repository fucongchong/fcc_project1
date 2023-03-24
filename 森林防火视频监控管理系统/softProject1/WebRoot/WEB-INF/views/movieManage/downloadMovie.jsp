<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="UTF-8">
  <title>视频下载</title>
</head>
<body>

<jsp:useBean id="mvbean" type="com.entity.Movie" scope="session" />

<!--从数据库将视频的地址传过来  -->



<ul>
<%
for(int i=0;i<mvbean.getMovieArray().size();i++)
{
 %>
<li>
  <p></p>
  <a href="../mov/<%=mvbean.getMovieArray().get(i).getMpaddress() %>" download="<%=mvbean.getMovieArray().get(i).getMname()%>">点击这里，可以下载右面视频</a>
  <video width="500" height="360" controls>
  <source src="../mov/<%=mvbean.getMovieArray().get(i).getMpaddress()%>">
  </video>   
  
</li>
<hr>
<%} %>
</ul>

</body>
</html>