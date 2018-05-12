<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title></title>
	</head>
	<body>

		<!-- Page Wrapper -->
			<div>

				<!-- Header -->
					<header id="header">
						<h1><a href="index.jsp">返回主页</a></h1>
						<nav>
							<a href="#menu">菜单</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<div class="inner">
							<h2>菜单</h2>
							<ul class="links">
								<li><a href="index.jsp">主页</a></li>
								<li><a href="prescriptionQuery.jsp">方剂查询</a></li>
								<li><a href="matrixShow.jsp">关系展示</a></li>
								<li><a href="relationShow.jsp">关系图解</a></li>
							</ul>
							<a href="#" class="close">Close</a>
						</div>
					</nav>
       </div>
	</body>
</html>