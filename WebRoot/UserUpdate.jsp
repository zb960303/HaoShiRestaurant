<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>更新用户</title>

<script type="text/javascript">
	function check(){
    	var res=document.getElementById("res");
    	var name=document.getElementById("name");
    	var pwd=document.getElementById("pwd");
    	var role=document.getElementById("role");
    	if(name.value.length==0||pwd.value.length==0||res.value==""||role.value==""){
    		alert("请填写完整");
					return false;
    	}
</script>
</head>
<body>
<div class="pd-20">
  <form action="AddUser.action" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="" id="name" name="user.uname" datatype="*2-16" nullmsg="用户名不能为空">
      </div>
      <div class="col-4"> </div>
      
      
      
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>密码：</label>
      <div class="formControls col-5">
        <input type="password" class="input-text" value="" placeholder="" id="pwd" name="user.upwd"  datatype="*" nullmsg="密码不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    
    <div class="row cl">
      <label class="form-label col-3">员工类型：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" id="role" name="user.userrole.urid" datatype="*" nullmsg="请选择员工类型！">
          <option value="" selected>请选择员工类型</option>
          <s:iterator id="user" value="RoleList">
          	<option value="<s:property value="#user.urid"/>"><s:property value="#user.urole"/></option>
          </s:iterator>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3">所在餐厅：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" id="res" name="user.restaurant.rid" datatype="*" nullmsg="请选择所在餐厅！">
          <option value="" selected>请选择餐厅</option>
          <s:iterator id="user" value="RestList">
          	<option value="<s:property value="#user.rid"/>"><s:property value="#user.rname"/></option>
          </s:iterator>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" onclick="return check()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});}
</script>
</body>
</html>