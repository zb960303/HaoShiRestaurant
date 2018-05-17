<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<title>好食餐厅</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link href="css/amazeui.min.css" type="text/css" rel="stylesheet" />
		<link href="css/style.css" type="text/css" rel="stylesheet" />
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/amazeui.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/date.js" ></script>
		<script type="text/javascript" src="js/iscroll.js" ></script>
		<script type="text/javascript">
		$(function(){
			$('#beginTime').date();
			$('#endTime').date({theme:"datetime"});
		});
		</script>
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default sq-head ">
		   <div class="am-header-left am-header-nav">
	          <a href="startOrder" class="">继续点餐</a>
           </div>
		   
	   </header>
	   <div style="height: 49px;"></div>
	    <ul class="eat-list">
	    <s:iterator id="CartList" value="OrderList">
		    	<li>
		    		<span class="name"><s:property value="#CartList.food.fname"/></span>
		    		
		    		<em class="">总价：￥<s:property value="#CartList.oprice"/></em>
		    		
		    		<div class="d-stock ">
		    			X<s:property value="#CartList.fnum"/>
		    		</div>
				    
		    	</li>
	    	</s:iterator>
	    	
	    </ul>
	    <div class="juli"></div>
	    <ul class="list-detail">
	    	<li class="time">
	    		<span>我的桌号：</span>
	    		<s:property value="#CartList.table.tid"/>号桌
	    		
	    	</li>
	    </ul>
	    <div class="juli"></div>
	    <!--就餐人数-->
	    
		<!--桌台-->
	    
		
        <div class="juli"></div>
	    
	    <div class="juli"></div>
	    <div class="pricebox">
	    <s:set name="sum" value="OrderPrice"/>
	    	<p>总价：<i><s:property value="#sum"/></i>元<p>
	    	<p>请确认支付：</p>
	    	<form action="Pay" method="post">
    			<button class="paybtn" type="submit" > 支付</button>
    		</form>
	    	
	    </div>
	    
		 <div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
		  
		</div>
		
		
	</body>
</html>