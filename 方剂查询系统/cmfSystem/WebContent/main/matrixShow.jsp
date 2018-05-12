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
								<h2>关系展示</h2>
								<p>通过算法设计进行药物与药物之间关系的深度挖掘，研究一种药物与其他药物之间是否配伍使用、使用频率、共同所在方剂等相关信息(矩阵)</p>
							</div>
						</header>

						<!-- Content -->
							<div class="wrapper">
								<div class="inner">
									<h3 class="major">请输您要查询的两味药（默认查询所有）</h3>
									<div>
								        
										    <table align="left">										
										      <tr>
										        <td>
										                       药物一：
						                       </td>
						                      </tr>
						                      <tr>
						                       <td>
										           <input name="matrixRelation.source" type="text" id="source"/> 
										        </td>
										      </tr>
										      <tr>
										        <td>
										                           药物二：
										        </td>
										      </tr>
						                      <tr>
										        <td>
										         <input name="matrixRelation.target" type="text" id="target"/> 
										        </td>
										     </tr>
										     <tr>
										        <td>
										          <s:submit value="查询" onclick="doAjax2()"/>
										        </td>
										      </tr>
										    </table>
								     
								       <br/><br/>
								    </div>

									<h3 class="major">结果矩阵</h3>
			
									<div>
									   <div>
									   	<table>
									       <thead>
										       <tr> 
										        <th>编号</th>
										        <th>药物一</th>
										        <th>药物二</th>
										        <th>所在方剂</th>			        
										      </tr>
									      </thead>
										  <tbody id="tbody2"> 
									             
									       </tbody> 
							               <tfoot id="tfoot2">
							                  
							               </tfoot> 
									 </table>
									   </div> 
									 </div>
									
								</div>
							</div>

					</section>
			</div>

		<!-- Scripts -->
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>
		    <script type="text/javascript" src="../assets/js/ajax.js"></script>
		
		   
	 <!-- 表格显示 -->
	<script type="text/javascript">
	var sourceArray=new Array();
	var targetArray=new Array();
	var prenameArray=new Array();
	 function doAjax2()  {
		 	var count=0;
		 	$("input:text").each(function(){
		 		 if($(this).val()!="")
		 			 count++;
		 	});
		 	if(count==1)
		    {
		          alert("警告：您只输入了一个查询条件，只有输入两个查询条件才能查询关系，否则默认为查询所有");
		    }
		 //分页
		 var intPageSize=10;
		 var intRowCount=0;
         var intPageCount=0;
         var intPage=1;
		//NO1)
			var ajax =createAJAX();
			//NO2)
			var method = "POST";
			var url = "${pageContext.request.contextPath}/matrixRelationAction?time="+new Date().getTime();
		//	var url = "${pageContext.request.contextPath}/matrixRelationAction?";
			
			ajax.open(method,url);
			//NO3)
			ajax.setRequestHeader("content-type","application/x-www-form-urlencoded")
			//NO4)
			
			var source=$("#source").val();
			var target=$("#target").val();
			
			var content = "matrixRelation.source=" + source+"&matrixRelation.target="+target;
			
			ajax.send(content);
			
			//-------------------------------------------等待
			
			//NO5
			ajax.onreadystatechange = function changedata(){	
				if(ajax.readyState == 4){	
					if(ajax.status == 200){
						//alert("aa");
						//NO6)返回JAVA格式的JSON文本
						var jsonJAVA = ajax.responseText;
						
						//p所代表的是java格式的json文本，是不能直接被js执行的
						//解决方案：将java格式的json文本，转成js格式的json文本
						//如何做：用js提供的一个函数搞定
						var jsonJS = eval("("+jsonJAVA+")");
						//输出错误信息
						if(jsonJS.msg!=null)
						{
							alert(jsonJS.msg);
						}
						var data = jsonJS.matrixRelations;
						intRowCount=data.length;
						intPageCount=Math.ceil(intRowCount/intPageSize);
						for (var i=0;i<data.length;i++) {  
							sourceArray[i]=data[i].source;
							targetArray[i]=data[i].target;
							prenameArray[i]=data[i].prename;
						}
                        $("#tbody2").html("");                        
                         for (i=0;i<10 && i<data.length;i++) {   
                        	 var str="";
 	                       	str +="<tr><td>"+(parseInt(i)+1)
 	                       		+ "</td><td>"
 	                       		+ data[i].source  
 	                            + "</td><td>"  
 	                            + data[i].target   
                                + "</td><td>"  
                                + data[i].prename                     
 	                            +"</td></tr>";       
 	                          $("#tbody2").append(str); 
 	                          
                         }	                         
                         if(i==data.length)
                        	{
                         	$("#tfoot2").html("");						
                         	if(i==1){
                        		intPage=1;
                        	}else{
                        		intPage=Math.ceil((i-1)/10);	
                        	}				
     	                    str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
     	                          "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
     	                          "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"下一页\" onclick=\"page4('"+i+"')\">"+
     	                          "</td></tr>"; 
     	                           
     	                    $("#tfoot2").append(str6);
                        	}
                         else if(i<=10)
                        	{
                        		$("#tfoot2").html("");						
     						intPage=Math.ceil((i-1)/10);				
     	                    str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
     	                          "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
     	                          "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page4('"+i+"')\">"+
     	                          "</td></tr>"; 
     	                    $("#tfoot2").append(str6);
                        	} 
                          else
                         {
 							$("#tfoot2").html("");						
 							intPage=Math.ceil((i-1)/10);				
 		                    str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
 		                          "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
 		                          "页&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page4('"+i+"')\">"+
 		                          "</td></tr>";     
 		                    $("#tfoot2").append(str6);
                         } 
	 				}
					
				}
			}
     }
	</script>
	<!-- 上一页 -->
     <script type="text/javascript">
     function page3(i)  {
    	
	    	$("#tbody2").html(""); 
	        var intPageSize=10;
		    var intRowCount=sourceArray.length;
	        var intPageCount=Math.ceil(intRowCount/intPageSize);
	        var intPage=1;
			var a=i;
			if(a%10==0)
			{
				i=a-20;
				a=a-10;
			}
			else
			{
				i=a-i%10-10;
				a=a-a%10;
			}
			for (i;i<a && i<sourceArray.length;i++) { 
        	   str4 =""; 
	           str4 += "<tr><td>"+(parseInt(i)+1)
	                + "</td><td>"
	            	+ sourceArray[i]
	                 + "</td><td>"  
	                 + targetArray[i]   
	                 + "</td><td>"  
	                 + prenameArray[i]  	              
	                 +"</td></tr>";  
             	 
               $("#tbody2").append(str4); 
			}
			if(i==sourceArray.length)
           	{
            	$("#tfoot2").html("");						
				intPage=Math.ceil((i-1)/10);				
				str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
                "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                "页&nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"下一页\" onclick=\"page4('"+i+"')\">"+
                "</td></tr>"; 
                $("#tfoot2").append(str6);
           	}else if(i<=10)
           	{
           		$("#tfoot2").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page4('"+i+"')\">"+
                      "</td></tr>"; 
                $("#tfoot2").append(str6);
           	}
            else
            {
				$("#tfoot2").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page4('"+i+"')\">"+
                      "</td></tr>";     
                $("#tfoot2").append(str6);
            }
     }
    </script>
     <!-- 下一页 -->
     <script type="text/javascript">
     function page4(i)  {
    	 $("#tbody2").html(""); 
	        var intPageSize=10;
		    var intRowCount=sourceArray.length;
	        var intPageCount=Math.ceil(intRowCount/intPageSize);
	        var intPage=1;
			 var a=i;
			 for (i;i-a<10 && i<sourceArray.length;i++) {
				var str5="";
				str5 += "<tr><td>"+(parseInt(i)+1)
	                 + "</td><td>"
	            	 + sourceArray[i]
	                 + "</td><td>"  
	                 + targetArray[i]   
	                 + "</td><td>"  
	                 + prenameArray[i]  	                
	                 +"</td></tr>";    
               $("#tbody2").append(str5); 
			} 
			 if(i==sourceArray.length)
	           	{
	            	$("#tfoot2").html("");						
					intPage=Math.ceil((i-1)/10);				
					str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
	                "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
	                "页&nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"下一页\" onclick=\"page4('"+i+"')\">"+
	                "</td></tr>"; 
	                $("#tfoot2").append(str6);
	           	}else if(i<=10)
	           	{
	           		$("#tfoot2").html("");						
					intPage=Math.ceil((i-1)/10);				
	                str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
	                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
	                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page4('"+i+"')\">"+
	                      "</td></tr>"; 
	                $("#tfoot2").append(str6);
	           	}
	            else
	            {
					$("#tfoot2").html("");						
					intPage=Math.ceil((i-1)/10);				
	                str6="<tr><td align=\"center\" colspan=\"5\">第"+intPage+
	                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
	                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"上一页\" onclick=\"page3('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page4('"+i+"')\">"+
	                      "</td></tr>";     
	                $("#tfoot2").append(str6);
	            }
	     }
     </script>
	</body>
</html>