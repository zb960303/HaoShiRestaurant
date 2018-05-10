<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
		<meta name="keywords" content="" />
		<title>茶部落</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/amazeui.min.js" type="text/javascript"></script>
		<link href="css/amazeui.min.css" type="text/css" rel="stylesheet" />
		<link href="css/style.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="css/bootstrap.min.css">  
    	<script src="js/bootstrap.min.js"></script>
		

</head>
  
  <body>
 
    <ul class="list-pro">
    <s:iterator id="Food" value="Foodlist">
    	<li>
			<a href="detail.html"><img src="images/1.png" class="list-pic" /></a>
			<div class="shop-list-mid">
				<div class="tit">
					<a href="detail.html">
		        		<s:property value="#Food.fname"/>
				    </a>
				</div>
		        <div class="am-gallery-desc">￥52</div>
		        </div>
		        <div class="list-cart">
		               <button type="button" class="btn btn-primary">加入购物车</button>  
		        </div>
			    	</li>
	</s:iterator>
    </ul>

  </body>
</html>
