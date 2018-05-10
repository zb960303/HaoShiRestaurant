<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	          <a href="index.html" class="">继续点餐</a>
           </div>
		   <div class="am-header-right am-header-nav">
	          <button type="button" class="am-btn am-btn-warning" id="doc-confirm-toggle" style="background: none; border: 0; font-size: 24px;">
                 <i class="am-header-icon am-icon-trash"></i>
	          </button>
            </div>
	   </header>
	   <div style="height: 49px;"></div>
	    <ul class="eat-list">
	    	<li>
	    		<span class="name">绿茶</span>
	    		<em class="price">￥2.0</em>
	    		<div class="d-stock ">
	                <a class="decrease">-</a>
	                <input id="num" readonly="" class="text_box" name="" type="text" value="1">
	                <a class="increase">+</a>
			    </div>
	    	</li>
	    	<li>
	    		<span class="name">绿茶</span>
	    		<em class="price">￥2.0</em>
	    		<div class="d-stock ">
	                <a class="decrease">-</a>
	                <input id="num" readonly="" class="text_box" name="" type="text" value="1">
	                <a class="increase">+</a>
			    </div>
	    	</li>
	    </ul>
	    <div class="juli"></div>
	    <ul class="list-detail">
	    	<li class="time">
	    		<span>送餐人数：</span>
	    		<button type="button" class="am-btn am-btn-primary" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">请选择就餐人数</button>
	    		<i class="am-icon-angle-right"></i>
	    	</li>
	    	<li class="time">
	    		<span>我的桌号：</span>
	    		<button type="button" class="am-btn am-btn-primary" data-am-modal="{target: '#doc-modal-2', closeViaDimmer: 0}">请选择桌台</button>
	    		<i class="am-icon-angle-right"></i>
	    	</li>
	    </ul>
	    <div class="juli"></div>
	    <!--就餐人数-->
	    <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
		  <div class="am-modal-dialog">
		  	<div class="am-modal-hd" style="height: 35px;">
		      <a href="javascript: void(0)" class="am-close am-close-spin" style="float: left;" data-am-modal-close>&times;</a>
		    </div>
		    <div class="am-modal-bd">
		       <ul class="numren">
		       	<li>1人</li>
		       	<li>2人</li>
		       	<li class="cur">3人</li>
		       	<li>4人</li>
		       	<li>5人</li>
		       	<li>6人</li>
		       	<li>7人</li>
		       	<li>8人</li>
		       	<li>9人</li>
		       	<li>10人</li>
		       </ul>
		    </div>
		  </div>
		</div>
		<!--桌台-->
	    <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
		  <div class="am-modal-dialog">
		  	<div class="am-modal-hd" style="height: 35px;">
		      <a href="javascript: void(0)" class="am-close am-close-spin" style="float: left;" data-am-modal-close>&times;</a>
		    </div>
		    <div class="am-modal-bd">
		       <ul class="num-left">
		       	 <li>桌台</li>
		       </ul>
		       <ul class="num-right">
		       	 <li>A区2号台位</li>
		       	 <li>A区2号台位</li>
		       	 <li>A区2号台位</li>
		       	 <li>A区2号台位</li>
		       	 <li>A区2号台位</li>
		       	 <li>A区2号台位</li>
		       </ul>
		    </div>
		  </div>
		</div>
		
        <div class="juli"></div>
	    <textarea placeholder="备注说明" class="bz-infor"></textarea>
	    <div class="juli"></div>
	    <div class="pricebox">
	    	<p>总价：<i>12.00</i>元（含运费10元）（<em>1</em>份）</p>
	    	<p>请选择支付方式并确认下单：</p>
	    	<button class="paybtn" type="button" > 微信支付</button>
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
		
		</script>
	</body>
</html>