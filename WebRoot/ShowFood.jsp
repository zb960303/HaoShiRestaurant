<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
   <head>
		<meta name="keywords" content="" />
		<title>好食餐厅</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/amazeui.min.js" type="text/javascript"></script>
		<link href="css/amazeui.min.css" type="text/css" rel="stylesheet" />
		<link href="css/style.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="css/bootstrap.min.css">  
    	<script src="js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
    		$(window).scroll(function(){

			if($(document).scrollTop()!=0){
			sessionStorage.setItem("offsetTop", $(window).scrollTop());
			} 
});

		window.onload = function()
{
			var _offset = sessionStorage.getItem("offsetTop");
			$(document).scrollTop(offsetTop);
};
    	</script>

</head>
  
  <body>
 
    <ul class="list-pro">
    <s:iterator id="Food" value="Foodlist">
    	<li>
			<img src="img/<s:property value="#Food.img"/>" class="list-pic" />
			<div class="shop-list-mid">
				<div class="tit">
		        		<s:property value="#Food.fname"/>   
				</div>
		        <div class="am-gallery-desc">
		        	<s:property value="#Food.fdes"/>
		        </div>
		        <div class="am-gallery-desc">
		       		 ￥<s:property value="#Food.fprice"/></div>
		        </div>
		        <div class="list-cart">
		        	<button type="button" class="btn btn-primary" onclick="showAtRigh('AddtoCart.action?FID=<s:property value="#Food.fid"/>')"><i class="fa fa-users"></i> 加入购物车</button>
		        </div>
			    	</li>
	</s:iterator>
    </ul>
<script>
 function showAtRight(url) {
			var xmlHttp;
			
			if (window.XMLHttpRequest) {
				// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlHttp=new XMLHttpRequest();	//创建 XMLHttpRequest对象
			}
			else {
				// code for IE6, IE5
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
		
			xmlHttp.onreadystatechange=function() {		
				//onreadystatechange — 当readystate变化时调用后面的方法
				
				if (xmlHttp.readyState == 4) {
					//xmlHttp.readyState == 4	——	finished downloading response
					
					if (xmlHttp.status == 200) {
						//xmlHttp.status == 200		——	服务器反馈正常			
						
						document.getElementById("content").innerHTML=xmlHttp.responseText;	//重设页面中id="content"的div里的内容
						executeScript(xmlHttp.responseText);	//执行从服务器返回的页面内容里包含的JavaScript函数
					}
					//错误状态处理
					else if (xmlHttp.status == 404){
						//alert("出错了☹   （错误代码：404 Not Found），……！"); 
						/* 对404的处理 */
						return;
					}
					else if (xmlHttp.status == 403) {  
						alert("出错了☹   （错误代码：403 Forbidden），……"); 
						/* 对403的处理  */ 
						return;
			        }
					else {
						alert("出错了☹   （错误代码：" + request.status + "），……"); 
						/* 对出现了其他错误代码所示错误的处理   */
						return;
					}   
				} 
		            
			  }
			
			//把请求发送到服务器上的指定文件（url指向的文件）进行处理
			xmlHttp.open("GET", url, true);		//true表示异步处理
			xmlHttp.send();
		}
		
		
		
</script>
  </body>
  
</html>
