<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.pojo.PaperPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题详情</title>
</head>
<body>

<jsp:useBean id="stuBean" type="com.entity.Student" scope="session"/>
<jsp:useBean id="paperpjBean" type="com.pojo.PaperPojo" scope="session"/>
<H1 align="center"><font color="black">主题详情</font></H1>

<%
Map<String, Object> ret=paperpjBean.getRetMap();
for(int i=0;i<stuBean.getStuArray().size();i++)
{
List<PaperPojo> p1=(List<PaperPojo>)ret.get("PaperList"+i);
 %>
<p align="center">
学号：
<label><%=stuBean.getStuArray().get(i).getSNo() %></label>

<p align="center">
姓名：
<label><%=stuBean.getStuArray().get(i).getSN() %></label>

<p align="center">
性别：
<label><%=stuBean.getStuArray().get(i).getGender() %></label>

<p align="center">
专业：
<label><%=stuBean.getStuArray().get(i).getDept() %></label>

<p align="center">
班级：
<label><%=stuBean.getStuArray().get(i).getClas() %></label>

<p align="center">
为该主题上传的论文：
<table border="1" align="center">
<tr>
<td>论文ID</td>
<td>论文题目</td>
<td>作者</td>
<td>出处</td>
<td>关键词</td>
<td>摘要</td>
<td>文件物理位置</td>
<td>上传时间</td>
</tr>
<%
for(int j=0;j<p1.size();j++)
{

 %>
<tr>
<td><%=p1.get(j).getPID() %></td>
<td><%=p1.get(j).getPN() %></td>
<td><%=p1.get(j).getAuthor() %></td>
<td><%=p1.get(j).getProvenance() %></td>
<td><%=p1.get(j).getKeyword()  %></td>
<td><%=p1.get(j).getDigest() %></td>
<td><%=p1.get(j).getFilePhysicalLocation() %></td>
<td><%=p1.get(j).getUploadTime() %></td>
</tr>

 <%
 }
  %>
</table>
<hr>
<%
 }
 %>
</body>
</html>