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
<link href="css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>后台登录 - H-ui.admin v2.3</title>

<script type="text/javascript">
    function checkForm(){
     var flag=true;
     var message=form1.message.value;
     if(message!='null'){
      alert(message);
      flag=false;
     }
     return flag;
    }
    
    function check(){
    	var res=document.getElementById("res");
    	var name=document.getElementById("name");
    	var pwd=document.getElementById("pwd");
    	if(name.value.length==0||res.value.length==0||pwd.value.length==0){
    		alert("请填写完整");
					return false;
    	}
    }
</script>

</head>
<body onload="checkForm()">
<input type="text" name="message" value="${sessionScope.message}">
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="UserLogin.action" method="post">
      <div class="row cl">
        
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe66a;</i></label>
        <div class="formControls col-8">
          <input id="res" name="user.restaurant.rid" type="text" placeholder="餐厅识别码" class="input-text size-L">
        </div>
         
        
      </div>
      <div class="row cl">
      	<label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="name" name="user.uname" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="pwd" name="user.upwd" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-8 col-offset-3" style="width:100px">
          <select name="user.userrole.urid" class="select" >
			<s:iterator id="user" value="RoleList">
          		<option value="<s:property value="#user.urid"/>"><s:property value="#user.urole"/></option>
          	</s:iterator>
		</select>
      </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L"  onclick="return check()" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 好食餐厅</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>