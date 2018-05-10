<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>茶部落</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/amazeui.min.js" type="text/javascript"></script>
		<link href="css/amazeui.min.css" type="text/css" rel="stylesheet" />
		<link href="css/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default sq-head ">
		   <div class="am-header-right am-header-nav">
	          <button type="button" class="am-btn am-btn-warning" id="doc-confirm-toggle" style="background: none; border: 0; font-size: 24px;">
                 <i class="am-header-icon am-icon-trash"></i>
	          </button>
            </div>
	   </header>
	    <div class="content-list" id="outer">
	    	<div class="list-left" id="tab">
	    		<s:iterator id="FoodCate" value="list">
	    		<li><a href="###" onclick="showAtRight('showFood.action?cateId=<s:property value="#FoodCate.fcid"/>')"><i class="fa fa-users"></i> <s:property value="#FoodCate.fcname"/></a></li>
	    		</s:iterator>
	    		
	    		
	    	</div>
	    	<div class="list-right" id="content">
	    		
	            <div class="list-cart">
			                <div class="d-stock ">
					                <a class="decrease">-</a>
					                <input id="num" readonly="" class="text_box" name="" type="text" value="0">
					                <a class="increase">+</a>
			                </div>
		                </div>  
	    	</div>
	    </div>
	    <!--底部-->
 <div style="height: 100px;"></div>
 <div class="fix-bot">
	   	  <a href="" class="list-js">合计：<i>0元</i><em>(0份)</em></a>
	   	  <a href="" class="list-jsk">选好了</a>
 </div>
 
 <div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-bd" style="height: 80px; line-height: 80px;">  您确定要清空饮品吗？</div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>

<script>
//购物数量加减
$(function(){
		$('.increase').click(function(){
			var self = $(this);
			var current_num = parseInt(self.siblings('input').val());
			current_num += 1;
			if(current_num > 0){
				self.siblings(".decrease").fadeIn();
				self.siblings(".text_box").fadeIn();
			}
			self.siblings('input').val(current_num);
			update_item(self.siblings('input').data('item-id'));
		})		
		$('.decrease').click(function(){
			var self = $(this);
			var current_num = parseInt(self.siblings('input').val());
			if(current_num > 0){
				current_num -= 1;
                if(current_num < 1){
	                self.fadeOut();
					self.siblings(".text_box").fadeOut();
                }
				self.siblings('input').val(current_num);
				update_item(self.siblings('input').data('item-id'));
			}
		})
	})
    
//删除提示信息   
    $(function() {
  $('#doc-modal-list').find('.am-icon-close').add('#doc-confirm-toggle').
    on('click', function() {
      $('#my-confirm').modal({
        relatedTarget: this,
        onConfirm: function(options) {
          var $link = $(this.relatedTarget).prev('a');
          var msg = $link.length ? '你要删除的饮品 为 ' + $link.data('id') :
            '确定了';
//        alert(msg);
        },
        onCancel: function() {
          alert('不删除');
        }
      });
    });
});

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
						alert("出错了☹   （错误代码：404 Not Found），……！"); 
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