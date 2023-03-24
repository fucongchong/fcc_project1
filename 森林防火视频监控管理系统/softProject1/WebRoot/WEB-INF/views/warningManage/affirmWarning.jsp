<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %> 
<%@ page import ="com.pojo.AffirmAlarmPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>火灾判断</title>
 
<body>
<form method="post" action="GetAffirmAlarm">
<jsp:useBean id="aaPojo" type="com.pojo.AffirmAlarmPojo" scope="session" />
<jsp:useBean id="moviePicPojo" type="com.pojo.MoviePicturePojo" scope="session" />
<!--从数据库将报警事件视频的地址传过来  -->

<%session.setAttribute("affirmNumber",aaPojo.getAffirmArray().size());

 %>


<ul>
<%
for(int i=0;i<aaPojo.getAffirmArray().size();i++)
{
 %>
<li>
  <p></p>
  <video width="500" height="360" controls>
  <source src="../mov/<%=aaPojo.getAffirmArray().get(i).getMpaddress()%>">
  </video>
  <%List<String> l1=moviePicPojo.getMoviePicArray().get(i).getPaddress(); %>
  <img src="../pic/<%=l1.get(0) %>" width="500" height="360" alt="场部-绿叶-下午-A点-5个饼1" />
  <img src="../pic/<%=l1.get(1)%> " width="500" height="360" alt="场部-绿叶-下午-A点-5个饼2" />
  <img src="../pic/<%=l1.get(2)%>" width="500" height="360" alt="场部-绿叶-下午-A点-5个饼3" />
  <img src="../pic/<%=l1.get(3)%>" width="500" height="360" alt="场部-绿叶-下午-A点-5个饼4" />
  <label><input name="fire<%=i%>" type="radio" value="正" />正 </label> 
  <label><input name="fire<%=i%>" type="radio" value="误" />误 </label>   
  <label><input name="mesBox<%=i%>" type="text"/></label> 
</li>
<hr>
<%} %>
</ul>
<label><input name="number" type="text" value="<%=aaPojo.getAffirmArray().size() %>" />当前报警事件数量：<%=aaPojo.getAffirmArray().size() %></label> 
<input type="submit" value="确认判断">
</form>
</body>
</html>