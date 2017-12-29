<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FileUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	String stuName=(String)session.getAttribute("stuName");
   %>
  <body>
    	<h1>欢迎使用作业提交系统</h1>
    	<h3><%=stuName %>同学</h3><a href="changePassword">修改密码</a>
    	<form action="FileUpload" method="post" enctype="multipart/form-data">
    		文  件：<input type="file" name="file"/><br/>
    	<input type="submit" value="提交"/> 
    </form>
  </body>
</html>
