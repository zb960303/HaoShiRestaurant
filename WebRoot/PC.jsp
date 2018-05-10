<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    	<title>The Marvel Cinematic Universe</title>
    	<link rel="stylesheet" href="css/bootstrap.min.css">  
    	<script src="js/jquery-2.1.1.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
    	<style type="text/css">
    		#footer-sec{
    			color: #7C7E7F;
    		}
    		.head-main-img {
                padding-bottom:50px;
                background: url(img/4.1.jpg) no-repeat 50% 50%;
                background-attachment: fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                width: 100%;
                display: block;
                height: auto;
                min-height:300px;
                color:#fff;
            }
            .head-main-img h1 {
                padding: 100px 2px 2px 10px;
                text-transform:uppercase;
            }

    	</style>
    </head>
	<body data-spy="scroll" data-target="#navbar" data-offset="0">
	<!-- 导航栏-->
			<nav class="navbar navbar-inverse navbar-fixed-top" id="navbar" style="opacity: 0.8">
	        <div class="container">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href="#">漫威电影宇宙</a>
	            </div>
	            <div class="navbar-collapse collapse">
	                <ul class="nav navbar-nav navbar-right">
	                    <li><a href="#home">主页</a></li>
	                    <li><a href="#movieInfo">影片介绍</a></li>
	                    <li><a href="#figure">人物介绍</a></li>
	                    <li class="dropdown">
	                    	<a href="" class="dropdown-toggle" data-toggle="dropdown">联系我</a>
	                    	<ul class="dropdown-menu">
	                    		<li><a href="" data-toggle="modal" data-target="#myModal">我的电子邮箱</a></li>
	                    		<li><a href="" data-toggle="modal" data-target="#QQ">我的QQ号</a></li>
	                    	</ul>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    	</nav>
	
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">联系我</h4>
		            </div>
		            <div class="modal-body">我的邮箱是:  zb960303@outlook.com</div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div>
		    </div>
		</div>

		<div class="modal fade" id="QQ" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">我的QQ号</h4>
		            </div>
		            <div class="modal-body">我的QQ号: 1527023273</div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div>
		    </div>
		</div>

	<!-- 轮播-->
	<section id="home" class="text-center">
	  
	         <div id="carousel-example" class="carousel slide" data-ride="carousel">

	             <div class="carousel-inner">
	                 <div class="item active">

	                     <img src="img/1.jpg" alt="" />
	                     <div class="carousel-caption" >
	                         <h4 class="back-light"></h4>
	                     </div>
	                 </div>
	                 <div class="item">
	                     <img src="img/2.jpg" alt="" />
	                     <div class="carousel-caption ">
	                         <h4 class="back-light">《死侍》弥漫着充满自知之明的幽默，但在其爱情故事和复仇故事方面又足够严肃以让观众保持投入</h4>
	                     </div>
	                 </div>
	                 <div class="item">
	                     <img src="img/3.jpg" alt="" />
	                     <div class="carousel-caption ">
	                         <h4 class="back-light">《X战警：逆转未来》在情感的处理上和它在对动作戏的处理上一样出色，在大场面的处理上是这个类型的电影里最出色的，令人眼花缭乱</h4>
	                     </div>
	                 </div>
	             </div>

	             <ol class="carousel-indicators">
	                 <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
	                 <li data-target="#carousel-example" data-slide-to="1"></li>
	                 <li data-target="#carousel-example" data-slide-to="2"></li>
	             </ol>
	         </div>
	    
	</section>

	<div style="width:100%; height:30px;" id="movieInfo"></div>
	<section  class="head-main-img">
         
            <div class="container">
                <div class="row text-center pad-row" >
                    <div class="col-md-12">
                        <h1>  超级电影 </h1>
                    </div>
                </div>
            </div>   
       </section>

	<div style="width:100%; height:60px;"></div>

<!-- 电影介绍-->
	<section >
            <div class="container">
            <div class="row text-center pad-row">
            	<div class="col-md-4  col-sm-4">
            		<a href="" class="thumbnail"><img class="img-rounded" src="img/fulian.jpg" alt="" /></a>
                    <h4> <strong>复仇者联盟系列</strong> </h4>
                    <p>
                        影片讲述了神盾局指挥官尼克·弗瑞为了对付《雷神》中被流放的洛基，积极奔走寻找最强者，在神盾局斡旋下将钢铁侠、美国队长、雷神托尔、绿巨人、黑寡妇和鹰眼侠六位超级英雄集结在一起，组成了复仇者联盟，共同携手应对邪神洛基
                    </p>
                    <a href="http://baike.baidu.com/link?url=7lqc04YpQe5VQq1-_C-k4LS1v7wOiHHQoDJYrqw-fZCQcoplGknFa_TZhrRNAIXKpey173zLyNs5WgpFSmsOH41b0EbZLGXC_i5qHRLt5tql2BnZ2gO3X9i9XtHavDvAiEtaPIVxirNnSA13D_RIOa" class="btn btn-primary" >阅读更多</a>    
                </div>
             	<div class="col-md-4  col-sm-4">
             		<a href="" class="thumbnail"><img class="img-rounded" src="img/x.jpg" alt="" /></a>
                     <h4> <strong>X战警系列</strong> </h4>
                     <p>
                         电影讲述一群身怀特异功能的队伍，为了保护人类与特种人的友善关系，极力与邪恶力量作斗争。为了保护自己和人类，X战警只有一条路，战斗到底。镭射眼、琴葛蕾
、是X战警的核心人物。
                     </p>
                     <a href="http://baike.baidu.com/link?url=qJsJP4Od5PAfQ3Nqw-KSWyKFEvWHwpbqX4TN8NaH6zx8dhnwg_VEXgrBzA1ahjEgqCLsVlkN0UyIx3R-pksro1H_ZS1mnbxSKMmmwkSWsVi" class="btn btn-primary" >阅读更多</a>    
                 </div>
            	<div class="col-md-4  col-sm-4">
            		<a href="" class="thumbnail"><img class="img-rounded" src="img/yinhe.jpg" alt="" /></a>
                    <h4> <strong>银河护卫队系列 &nbsp&nbsp<span class="label label-default">有新电影哦</span></strong> </h4>
                    <p>
                        影片剧情讲述因偷走神秘球体而被疯狂追杀的“星爵”彼得·奎尔被迫结盟四个格格不入的乌合之众——火箭浣熊、树人格鲁特、卡魔拉及毁灭者德拉克斯，他们必须破釜沉舟决一死战，才可能拯救整个银河系
                    </p>
                    <a href="http://baike.baidu.com/link?url=8pv458njuj48fImT3sHVZKeq9DtDUSU82DSixKlRiJX8K-bVC8s8jWTwtLZg3N4NJcjM8oUfMfeqx418QjTHh38ekCrEKl5Oo_BAvczyQNV7Wrev7sW3EgG_duLuOj_3PsDxM417Rjr5ytegLoUda_" class="btn btn-primary" >阅读更多</a>    
                </div>   
            </div>
            </div>
	</section>

<div style="width:100%; height:60px;" id="figure"></div>


	<section  class="head-main-img">
         
            <div class="container">
                <div class="row text-center pad-row" >
                    <div class="col-md-12">
                        <h1>  部分人物介绍 </h1>
                    </div>
                </div>
            </div>   
       </section>

		<div style="width:100%; height:60px;"></div>


			<!-- 人物介绍-->
        <section id="intro">
            <div class="container">
            <div class="row text-center" >
            <div class="col-md-12">
             
                 <div class="row text-center pad-row  ">
					<div class="col-md-3 col-sm-3 ">
                        <img class="img-circle" src="img/captain.jpg" alt="" />
                        <h3><strong><a data-toggle="collapse" data-target="#meiguo">美国队长</a></strong> </h3>
                        <p id="meiguo">
		                                美国队长拥有人类巅峰体能，有着超强的力量、速度、耐力和反应能力，他也是地球上最好的格斗高手之一。美国队长的主要武器是一个盾牌，由原始亚德曼金属制成，几乎坚不可摧，可用来攻击或防守。
                        <br><br>
                            <a href="http://baike.baidu.com/link?url=q6yzM2qA6wlzGR5O6k_CUq8Bu8qr5gt7mK2D6OSmFAr7SwdFIPwQZjUXZuQ53H4whR390Bhrl6Lf1qJJ9m8azAL1KEY1VwNqT5RLvTQQ6aPRfrNb80ycfVSGbabI7tar" class="btn btn-primary" ><span class="glyphicon glyphicon-tag"></span> 阅读更多</a>
                        </p>
                    </div>
                    <div class="col-md-3 col-sm-3 ">
                        <img class="img-circle" src="img/gangtiexia.jpg" alt="" />
                           <h3><strong><a data-toggle="collapse" data-target="#gangtie">钢铁侠</a></strong> </h3>
                        		<p id="gangtie">
		                                除了装甲赋予他的能力外，发明天才斯塔克仍不断的创造出新的科技并不停的改良现有的科技。这样的特质延续至当他遇见强敌与危机时，让他可以以不寻常但有效的运用他的装甲。

                            	<br><br>
                            		<a href="http://baike.baidu.com/link?url=jlyacTF5Cls4StQgqviVX7mKXrdMiYsRusvSfGHmxQy6ebRMMLW78P4vcmFD_aj2U9rmCEeCa8c9Ya9eJaEWZZYhz2Ek7nfJWhjUUcd0eQRRYO3NSZB5DYKTYgy_eVxPezNeKxjNKhch3K1qiza1fa" class="btn btn-primary" ><span class="glyphicon glyphicon-tag"></span>  阅读更多</a>
                            	</p>
                    </div>
                    <div class="col-md-3 col-sm-3 ">
                        <img class="img-circle" src="img/zhizhuxia.jpg" alt="" />
                           <h3><strong><a data-toggle="collapse" data-target="#zhizhu">蜘蛛侠</a></strong> </h3>
                        		<p id="zhizhu">
		                                蜘蛛感应：像蜘蛛一样通过空气震动来获取信息，感知周围一切。
										蜘蛛力量：蜘蛛等比例放大的力量，力气可达15—20吨。
										吸附能力：手脚可以吸附到任何坚固表面上。
										超人般的耐力、反应、敏捷和速度
                            	<br><br>
                            <a href="http://baike.baidu.com/link?url=EULBe36G46j26LwuPdIQxX7D-mnDpLvkJ3vk0DeP1MjpKhV8_nfRDb_hZXlC8pWJ1w0jRxbxxJDi3xBAmSL4mAnk8_svbev7ja7F4x6oZRLkgUxL4s8HB6bwo344D2qc" class="btn btn-primary" ><span class="glyphicon glyphicon-tag"></span>  阅读更多</a>
                            </p>
                    </div>
                    <div class="col-md-3 col-sm-3 ">
                        <img class="img-circle" src="img/sishi.jpg" alt="" />
                           <h3><strong><a data-toggle="collapse" data-target="#sishi">死侍</a></strong> </h3>
                        		<p id="sishi">
		                                在早期接受“X武器”的实验，结果身体变得十分耐打，而且无论受到何种武器的攻击都能够迅速再生，甚至身体四分五裂也能恢复原状，但会留下疤痕。曾抓住金刚狼好进行亚德曼金属手术。
                            	<br><br>
                            <a href="http://baike.baidu.com/link?url=QRDNL15a_SNBvq6AkIfV8qVpxPGlNK1l6xjlLDNZY1BBcp_ncLuOCYJxnAq8kxJi3ATzbylg3RxU681TxSf5KaboTYVZZvOP42bjowolHrS" class="btn btn-primary" ><span class="glyphicon glyphicon-tag"></span>  阅读更多</a>
                            </p>
                    </div>
                     
            </div>
            </div>
            </div>
            </div>
        </section>
	<!-- footer-->
	<div style="width:100%; height:60px;"></div>
	<section id="footer-sec" style="background-color: #000;opacity: 0.8">
             
            <div class="container">
            <div class="row  pad-bottom" >
            <div >
            <ul id="myTab" class="nav nav-tabs">
                <li class="active">
                    <a href="#AboutMe" data-toggle="tab">
                        关于我
                    </a>
                </li>
                <li><a href="#AboutThis" data-toggle="tab">关于页面</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="AboutMe">
                    <h4> <strong>关于我</strong> </h4>
                            <p>
                                本人爱看科幻电影，尤其是漫威电影宇宙里的电影。漫威电影宇宙电影几乎抛开漫画而去创作全新的剧本，自然有利也有弊。我们能够得以在大银幕上看到耳目一新的故事，却也可能见到自己不愿看到的发展。
                            </p>
                </div>
                <div class="tab-pane fade" id="AboutThis">
                	<h4> <strong>版权所有</strong> </h4>
                            <p>
                               201538013 <br />
                               章彬
                            </p>
                </div>
            </div>
            </div>          
               </div>
            </div>
    </section>
	</body>
	</html>
