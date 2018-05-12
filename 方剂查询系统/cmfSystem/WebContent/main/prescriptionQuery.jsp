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
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="../assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="../assets/css/ie8.css" /><![endif]-->
	    <style type="text/css">
	         #tablestyle1{
	                      table-layout:fixed ;
	         }
	         .tbodystyle1{
	             font-size: 0.7em;
	         }
	    </style>
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
								<h2>方剂查询</h2>
								<p>方剂查询系统旨在摒弃繁琐的传统纸质资料查询，实现高精确度的快速查询。</p>
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
										           1.查看全部方剂
										        </td>
										      </tr>
										      <tr>
										        <td>
										          2.输入方剂名
										        </td>
										      </tr>
										      <tr>
										        <td>
										          <input name="prescription.name" type="text" id="name"/>
										        </td>
										      </tr>
										      <tr>
										        <td>
										         3.按所含药物查找
										        </td>
										      </tr>
										      <tr>
										        <td>
										          <input name="medname" type="text" id="medname"/>
										        </td>
										      </tr>
										      <tr>
										        <td>
										          4.按功能查找
										        </td>
										      </tr>
										      <tr>
										        <td>
										          <input type="text" name="prescription.functions" id="functions"/>
										        </td>
										      </tr>
										      <tr>
										        <td>
										          5.按主治疾病查找
										       </td>
										     </tr>
										      <tr>
										        <td>
										        	<input name="prescription.majorfunction" type="text" id="majorfunction"/>
										        </td>
										      </tr>
										      <tr>
										        <td>
										          6.按适用症状查找
										        </td>
										      </tr>
										      <tr>
										        <td>
										          <input type="text" name="use" id="use"/>
										        </td>
										      </tr>
										      <tr>
										        <td>
										          7.按摘要查看方剂
										        </td>
										      </tr>
										      <tr>
										        <td>
										          <input type="text" name="prescription.abstr" id="abstr"/>
										        </td>
										      </tr>
										    
										       <tr>
										        <td>
										        	<s:submit value="查询" onclick="doAjax()"/>
										        </td>
										      </tr>
										    </table>
								         
								       <br/><br/>
								    </div>

									<h3 class="major">方剂表：</h3>
									<div>
									   <table id="tablestyle1">
									      
									          <thead>
		                                        <tr>
		                                             <th width="70px">编号</th>
		                                             <th width="80px">方剂名</th>
											         <th width="120px">方剂组成</th>
											         <th width="140px">主治</th>
											         <th width="120px">功能</th>
											         <th width="120px">适用症状</th>
											         <th>摘要</th>											      
		                                        </tr>
		                                    </thead> 
		   	
									        <tbody id="tbody1" class="tbodystyle1"> 
									             
									       </tbody> 
							               <tfoot id="tfoot1">
							                  
							               </tfoot>  
									    </table> 
									    
									    
									 </div>
									<div id="div1"></div>
								</div>
								
							</div>

					</section>
			</div>

		<!-- Scripts--> 
			<script src="../assets/js/skel.min.js"></script>
			<script  src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>
			
		<!--    表格显示 -->
	<script type="text/javascript">
	var nameArray=new Array();
	var preArray=new Array();
	var majorfunctionArray=new Array();
	var functionsArray=new Array();
	var useArray=new Array();
	var abstrArray=new Array();
	 function doAjax()  {
		 var count=0;
		 	$("input:text").each(function(){
		 		 if($(this).val()!="")
		 			 count++;
		 	});
		 	if(count>1)
		    {
		          alert("警告：您输入的查询条件超过一个，会按照最上面的一个查询条件来查询");
		    }
			 var intPageSize=10;
			 var intRowCount=0;
	         var intPageCount=0;
	         var intPage=1;
			var name=$("#name").val();
			var medname=$("#medname").val();
			var functions=$("#functions").val();
			var majorfunction=$("#majorfunction").val();
			var use=$("#use").val();
			var abstr=$("#abstr").val();
			 $.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/viewPreAction?",
					data:{"prescription.name":name,
						"medname":medname,
						"prescription.functions":functions,
						"prescription.majorfunction":majorfunction,
						"use":use,
						"prescription.abstr":abstr
						},
					success:function(backData){
						var data=backData.prescriptions;
						//输出错误信息
						if(backData.msg!=null)
						{
							alert(backData.msg);
						}
						intRowCount=data.length;
						intPageCount=Math.ceil(intRowCount/intPageSize);
						$("#tbody1").html(""); 
						for (var i=0;i<data.length;i++) {            	 
	                   	 	var str1="";
	                   	   
	                   	 	for (var j=0;j<data[i].pre.length;j++){
	                   	 		if(j==data[i].pre.length-1){
	                   	 			str1+=data[i].pre[j].medname+":"+data[i].pre[j].dose;
	                   	 		}
	                   	 		else{
	                   	 			str1+=data[i].pre[j].medname+":"+data[i].pre[j].dose+",";
	                   	 		}
	                   	 	}	                   	    
	                   	 	nameArray[i]=data[i].name;
	                   	    preArray[i]=str1;
	                   	    majorfunctionArray[i]=data[i].majorfunction;
	                   	    functionsArray[i]=data[i].functions;
	                 	    useArray[i]=data[i].use;
	                 	    abstrArray[i]=data[i].abstr;
						}
                        for (i=0;i<10 && i<data.length;i++) {            	
	                   	 	var str = "";  
	                   	 	var str1="";	                                      	   
	                   	 	for (var j=0;j<data[i].pre.length;j++){
	                   	 		if(j==data[i].pre.length-1){
	                   	 			str1+=data[i].pre[j].medname+":"+data[i].pre[j].dose;
	                   	 		}
	                   	 		else{
	                   	 			str1+=data[i].pre[j].medname+":"+data[i].pre[j].dose+",";
	                   	 		}
	                   	 	}	

	                       	str += "<tr><td>"+(i+1)
	                       		+ "</td><td>"
	                       		+ data[i].name  
	                            + "</td><td>"  
	                            + str1   
	                            + "</td><td>"  
	                            + data[i].majorfunction
	                            + "</td><td>"   
	                            + data[i].functions   
	                            + "</td><td>"   
	                            + data[i].use  
	                            +"</td><td>"  
	                            +data[i].abstr  	                            
	                            +"</td></tr>";  
	            	 
	                          $("#tbody1").append(str); 
	                          
                        }
                        
                        if(i==data.length)
                       	{
                        	$("#tfoot1").html("");
                        	if(i==1){
                        		intPage=1;
                        	}else{
                        		intPage=Math.ceil((i-1)/10);	
                        	}
    									
    	                    str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
    	                          "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
    	                          "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"下一页\" onclick=\"page2('"+i+"')\">"+
    	                          "</td></tr>"; 
    	                           
    	                    $("#tfoot1").append(str6);
                       	}
                        else if(i<=10)
                       	{
                       		$("#tfoot1").html("");						
    						intPage=Math.ceil((i-1)/10);				
    	                    str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
    	                          "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
    	                          "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page2('"+i+"')\">"+
    	                          "</td></tr>"; 
    	                    $("#tfoot1").append(str6);
                       	} 
                         else
                        {
							$("#tfoot1").html("");						
							intPage=Math.ceil((i-1)/10);				
		                    str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
		                          "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
		                          "页&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page2('"+i+"')\">"+
		                          "</td></tr>";     
		                    $("#tfoot1").append(str6);
                        } 
				}
				});		
			 $("table:first tr td input:text").val("");
	     }
	</script>
     <!-- 上一页 -->
     <script type="text/javascript">
     function page1(i)  {   	
	    	$("#tbody1").html(""); 
	        var intPageSize=10;
		    var intRowCount=nameArray.length;
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
			for (i;i<a && i<nameArray.length;i++) { 
        	   str4 =""; 
	           str4 += "<tr><td>"+(parseInt(i)+1)
	                + "</td><td>"
	            	+ nameArray[i]
	                 + "</td><td>"  
	                 + preArray[i]   
	                 + "</td><td>"  
	                 + majorfunctionArray[i]  
	                 + "</td><td>"   
	                 + functionsArray[i]     
	                 + "</td><td>"   
	                 + useArray[i]   
	                 +"</td><td>"  
	                 +abstrArray[i]    	             
	                 +"</td></tr>";  
             	 
               $("#tbody1").append(str4); 
			}
			if(i==nameArray.length)
           	{
            	$("#tfoot1").html("");						
				intPage=Math.ceil((i-1)/10);				
				str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
                "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                "页&nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"下一页\" onclick=\"page2('"+i+"')\">"+
                "</td></tr>"; 
                $("#tfoot1").append(str6);
           	}else if(i<=10)
           	{
           		$("#tfoot1").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page2('"+i+"')\">"+
                      "</td></tr>"; 
                $("#tfoot1").append(str6);
           	}
            else
            {
				$("#tfoot1").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page2('"+i+"')\">"+
                      "</td></tr>";     
                $("#tfoot1").append(str6);
            }
     }
    </script>
     <!-- 下一页 -->
     <script type="text/javascript">
     function page2(i)  {
			$("#tbody1").html(""); 	
			 var intPageSize=10;
			 var intRowCount=nameArray.length;
	         var intPageCount=Math.ceil(intRowCount/intPageSize);
	         var intPage=1;
			 var a=i;
			 for (i;i-a<10 && i<nameArray.length;i++) {
				var str5="";
				str5 += "<tr><td>"+(parseInt(i)+1)
	                 + "</td><td>"
	            	 + nameArray[i]
	                 + "</td><td>"  
	                 + preArray[i]   
	                 + "</td><td>"  
	                 + majorfunctionArray[i]  
	                 + "</td><td>"   
	                 + functionsArray[i]     
	                 + "</td><td>"   
	                 + useArray[i]   
	                 +"</td><td>"  
	                 +abstrArray[i]    	                 
	                 +"</td></tr>";  
               $("#tbody1").append(str5); 
			} 
			if(i==nameArray.length)
           	{
            	$("#tfoot1").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"下一页\" onclick=\"page2('"+i+"')\">"+
                      "</td></tr>"; 
                       
                $("#tfoot1").append(str6);
           	}else if(i<=10)
           	{
           		$("#tfoot1").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" disabled=\"disabled\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page2('"+i+"')\">"+
                      "</td></tr>"; 
                $("#tfoot1").append(str6);
           	}
            else
            {
				$("#tfoot1").html("");						
				intPage=Math.ceil((i-1)/10);				
                str6="<tr><td align=\"center\" colspan=\"7\">第"+intPage+
                      "页&nbsp;&nbsp;&nbsp;共"+intPageCount+
                      "页&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"上一页\" onclick=\"page1('"+i+"')\"> &nbsp;&nbsp;&nbsp;<input type=\"button\"  value=\"下一页\" onclick=\"page2('"+i+"')\">"+
                      "</td></tr>";     
                $("#tfoot1").append(str6);
            }
   
 }
			 
    </script>
	
	</body>
</html>