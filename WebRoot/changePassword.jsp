<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="md5.js"></script>
   <script type="text/javascript">
   		function f(){
			//hash = hex_md5("12324");
			var pw=document.getElementById("newPW");
  			var confirm=document.getElementById("confirm");
  			if(pw.value==""){
  				document.getElementById("msg").innerHTML="密码不得为空";
  			}
  			if(pw.value==confirm.value){
  				pw.value=hex_md5(pw.value);
  				document.getElementById("form2").submit();
  			}
  			else{
  				document.getElementById("msg").innerHTML="两次输入密码不一致";
  			}
  			//alert(password.value);
		}
		//var password=document.getElementById("password");
		//function passwdText(){
		//	password.value="默认为学号";
		//}
   </script>
  </head>
  
  <body>
  <%
  		String stuname="";
  		if(session.getAttribute("stuName")==null){
  			response.sendRedirect("checkUser");
  		}else{
  			stuname=(String)session.getAttribute("stuName");
  		}
   %>
    <h1>修改密码</h1>
    <form action="changePassword" method="post" id='form2'>
    <h3><font color="green"><%=stuname %></font>同学</h3>
    	新密码：<input type="password" id="newPW" name="newPW" style="width:150px; height:20px;" /><br/>
    	确&nbsp;认：<input type="password" id="confirm" name="confirm" style="width:150px; height:20px;" /><br/>
    	<div><font color="red" id="msg"></font></div>
  		<input type="button" style="width:90; height:30" onclick="f();" value="保存" />
    </form>
  </body>
</html>
