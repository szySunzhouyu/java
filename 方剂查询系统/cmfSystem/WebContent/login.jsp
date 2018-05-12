<%@ page language="java" import="java.util.*"  pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆页面</title>
<!-- For-Mobile-Apps -->
<title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

     <!-- Style --> 
    <link rel="stylesheet" href="assets/css/style.css" type="text/css" media="all" />
</head>
<body>
<div class="container">
<h1>方剂查询系统</h1>
	<div class="signin">
     	<s:form action="loginAction">
	      	<input type="text" name="admin.username" class="user" value="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'username';}" />
	      	<input type="password" name="admin.password" class="pass" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}" />
	      	<label>
		  		<input type="checkbox" value="Remember-Me" /> 记住密码?
		  	</label>
          	<input type="submit" value="登陆" />
	 	</s:form>
	</div>
</div>

</body>
</html>