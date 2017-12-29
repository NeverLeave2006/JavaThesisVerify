<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	response.setCharacterEncoding("utf-8");
  	String msg=(String)request.getAttribute("msg");
  	if(msg==null)msg="";
   %>
   <script type="text/javascript" src="md5.js"></script>
   <script type="text/javascript">
   		function f(){
			//hash = hex_md5("12324");
  			var password=document.getElementById("password");
  			password.value=hex_md5(password.value);
  			//alert(password.value);
		}
		//var password=document.getElementById("password");
		//function passwdText(){
		//	password.value="默认为学号";
		//}
   </script>
  <body>
    <h1>作业提交系统</h1>
    <form method="post" action="checkUser" name="login">
   		学    号 <input type="text" name="stunum" style="width:150px; height:20px;"/><br>
  		密    碼 <input type="password" id="password" name="password" style="width:150px; height:20px;" /><br/>
  		<div><font color="red"><%=msg %></font></div>
  		<input type="submit" style="width:90; height:30" onclick="f();" value="登錄" />
    </form>
     	
  </body>
</html>
