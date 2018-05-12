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
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="../assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="../assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Page Wrapper -->
			<div>

				<!-- Header -->
					<header id="header">
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

				<!-- Banner -->
					<section id="banner">
						<div class="inner">
							<div class="logo"><span class="icon fa-diamond"></span></div>
							<h2>方剂管理系统</h2>
							<p>欢迎来到中药方剂管理系统，为您提供全面的中药方剂大全...</p>
						</div>
					</section>

				<!-- Wrapper -->
					<section id="wrapper">

						<!-- One -->
							<section id="one" class="wrapper spotlight style1">
								<div class="inner">
									<a href="#" class="image"><img src="../images/pic01.jpg" alt="" /></a>
									<div class="content">
										<h2 class="major">方剂查询</h2>
										<p>方剂查询系统旨在摒弃繁琐的传统纸质资料查询，实现高精确度的快速查询。以下设计的方剂查询系统可实现多条件查询，大幅提高方剂药物信息查询速度。</p>
										<a href="prescriptionQuery.jsp" class="special">更多</a>
									</div>
								</div>
							</section>

						<!-- Two -->
							<section id="two" class="wrapper alt spotlight style2">
								<div class="inner">
									<a href="#" class="image"><img src="../images/pic02.jpg" alt="" /></a>
									<div class="content">
										<h2 class="major">关系展示</h2>
										<p>通过算法设计进行药物与药物之间关系的深度挖掘，研究一种药物与其他药物之间是否配伍使用、使用频率、共同所在方剂等相关信息(矩阵)</p>
										<a href="matrixShow.jsp" class="special">更多</a>
									</div>
								</div>
							</section>

						<!-- Three -->
							<section id="three" class="wrapper spotlight style3">
								<div class="inner">
									<a href="#" class="image"><img src="../images/pic03.jpg" alt="" /></a>
									<div class="content">
									    <h2 class="major">关系图解</h2>
										<p>通过对力导向图原理的拓展应用实现药物关系图的拖拽功能，以及通过查询单味药物来展示与该药物有联系的其他药物的发散关系图。</p>
										<a href="relationShow.jsp" class="special">更多</a>
										
									</div>
								</div>
							</section>

						<!-- Four -->
							<section id="four" class="wrapper alt style1">
								<div class="inner">
								<p>我不去想是否能够成功<br/>
								既然选择了远方<br/>
								便只顾风雨兼程<br/>
								</p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我不去想身后会不会袭来寒风冷雨<br/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;既然目标是地平线<br/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;留给世界的只能是背影<br/>
								</p>
									<h2 class="major">开发人员</h2>
									
									<ul class="actions">
										<li><a href="#" class="button">彭莹莹</a></li>
										<li><a href="#" class="button">薛罡</a></li>
										<li><a href="#" class="button">孙洲宇</a></li>
										<br/>
										<li><a href="#" class="button">殷淑娟</a></li>
										<li><a href="#" class="button">胡创</a></li>
										<li><a href="#" class="button">葛文华</a></li>
								   </ul>
								</div>
							</section>
		        </section>
			</div>

		<!-- Scripts -->
			<script src="../assets/js/skel.min.js"></script>
			<script  src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>

	</body>
</html>