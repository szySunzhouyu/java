<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="../assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="../assets/css/ie8.css" /><![endif]-->
		
	</head>
	<body>
       
		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
				<jsp:include page="header-menu.jsp"/>

				<!-- Wrapper -->
					<section id="wrapper">
						<header>
							<div class="inner">
								<h2>关系图解</h2>
								<p>通过对力导向图原理的拓展应用实现药物关系图的拖拽功能，以及通过查询单味药物来展示与该药物有联系的其他药物的发散关系图。</p>
							</div>
						</header>

						<!-- Content -->
							<div class="wrapper">
								<div class="inner">
									<h3 class="major">请输入您的查询条件</h3>
									<div>
										    <table align="center" id="tablestyle">
										     <tr>
										        <td>
										          输入药物名
										        </td>
										      </tr>
										      <tr>
										        <td>
										          <input type="text" name="medname" id="input2"> 
										        </td>
										      </tr>
										       <tr>
										        <td>
										          <s:submit type="button" value="查看" id="evtBtn" onclick="myclick()"/>
										        </td>
										      </tr>
										    </table>
								    </div>

									<h3 class="major">关系显示</h3>
									<div>
									   <div><%@include file="relation.jsp"%></div> 
									 </div>
									
								</div>
							</div>

					</section>
			</div>

		<!-- Scripts -->
			<script src="../assets/js/skel.min.js"></script>
			<script type="text/javascript" src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>
		
	</body>
</html>