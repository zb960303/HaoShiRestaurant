<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>订单列表</title>
</head>
<body>
<div class="pd-20">
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="IsBill.action"  class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e1;</i>已结账</a> <a href="NotBill.action"  class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6dd;</i> 未结账</a> <a href="OrderList.action"  class="btn btn-danger radius"><i class="Hui-iconfont">&#xe667;</i>所有订单</a></span> 
		当前用户:  ${sessionScope.user.uname}
	</div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">订单列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">订单编号</th>
				<th width="150">桌号</th>
				<th width="90">菜名</th>
				<th width="150">数量</th>
				<th width="130">价格</th>
				<th width="100">是否已结账</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator id="OrderList" value="OrderList">
			<tr class="text-c">
				
				<td><s:property value="#OrderList.oid"/></td>
				<td><s:property value="#OrderList.table.tid"/></td>
				<td><s:property value="#OrderList.food.fname"/></td>
				<td><s:property value="#OrderList.fnum"/></td>
				<td><s:property value="#OrderList.oprice"/></td>
				<td class="td-status"><span class="label label-success radius"><s:property value="#OrderList.isBill"/></span></td>
				
			</tr>
		</s:iterator>
			
		</tbody>
	</table>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 


</body>
</html>