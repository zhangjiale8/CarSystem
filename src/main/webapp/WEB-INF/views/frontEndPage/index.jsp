<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>登录阳光好车</title>
<link rel="shortcut icon" href="resource/images/title.jpg" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/base.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/home.css" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="resource/js/Plugs/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/home_ban.js"></script>
<script type="text/javascript" src="resource/js/Plugs/eg_top_search.js"></script>
<script
	src="<%=request.getContextPath()%>/resource/assets/layer/layer.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/snncar.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/scrollBar.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/index.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/item/itemPortion.js"></script>
</head>

<body>
	<div class="egc-top">
		<div class="nav-cent">
			<div class="top-r">
				<a href="toRegister" id="b-regist">注册<small>|</small></a> <a
					href="javascript:void(0);" style="display: none" id="b-name"><small
					id="text">${userName }</small> <small id="role" hidden="hidden">${roleID }</small><small>|</small></a>
				<a href="login" id="b-login" style="margin-left: 15px"
					class="b-login">登陆</a> <a href="login" id="b-back"
					style="margin-left: 15px; display: none;" class="b-login">后台</a> <a
					href="cancel" id="b-cancel"
					style="display: none; margin-left: 15px" class="b-cancel">退出</a>
			</div>
			<div class="top-l">全国统一客服热线：400-877-9288</div>
			<div class="clear_fix"></div>
		</div>
	</div>
	<div class="navigation">
		<div class="nav-cent">
			<div class="logo">
				<a href="index"><img src="resource/images/logo.png" width="240" /></a>
			</div>

			<div class="hot-phone">
				<i></i> <span class="js-change-phone">400-877-9288</span>
			</div>
		</div>
	</div>
	<ul class="navmenu">
		<li class="active"><a href="index">首页</a><span></span></li>
		<li><a href="itemList" data-item-id='1' id='itemList'>我要买车</a><span></span></li>
		<li><a href="itemListFitting" id='itemListFitting'
			data-item-id='2'>购买配件</a><span></span></li>
		<li><a href="memberCenter">会员中心</a><span></span></li>
		<li><a href="getGuestBook">查看留言</a><span></span></li>
	</ul>
	<div class="clear_fix"></div>
	<div class="stress-search-box row">
		<div class="stress-close">
			<a href="javascript:;"></a>
		</div>
		<div class="nav-cents">
			<ul>
				<li class="logo"><a href="index"><img
						src="resource/images/logo.png" width="180" /></a></li>
				<li><a href="index">首页</a></li>
				<li><a href="itemList" data-item-id='1' id='itemList'>我要买车</a><span></span></li>
				<li><a href="itemListFitting" id='itemListFitting'
					data-item-id='2'>购买配件</a><span></span></li>
				<li><a href="memberCenter">会员中心</a></li>
				<li><a href="getGuestBook">查看留言</a></li>

			</ul>

		</div>
	</div>
	<!--banner广告-->
	<div class="banner">
		<!--左侧买车-->
		<div class="mainmenu">
			<div class="sel-area">
				<div class="all-sort-list">
					<div class="item">

						<div class="active-banner fl" style="width: 265px;margin-top: 0px;height: 400px"> 
							<a href="#">
								<h2>
									<font color="#f79630">259项</font>全面检测
								</h2>
								<p>严苛检测标准，无事故</p> <img src="resource/images/sun_banner.jpg" width="265px" height="400px"/>
							</a>
						</div>


					</div>
					<!--  <div class="items">
						<h3>
							<div class="border">
								<a href="">价格</a>
							</div>
							<ul>
								<li><a href="#">5万以下</a></li>
								<li><a href="#">5-10万</a></li>
								<li><a href="#">10-15万</a></li>
								<li><a href="#">15-20万</a></li>
								<li><a href="#">20-25万</a></li>
								<li><a href="#">25-40万</a></li>
								<li><a href="#">40万以上</a></li>
							</ul>
						</h3>
					</div>
					<div class="items">
						<h3 style="border-bottom: 0px;">
							<div class="border">
								<a href="">车型</a>
							</div>
							<ul>
								<li><a href="#">SUV</a></li>
								<li><a href="#">商务车</a></li>
								<li><a href="#">跑车</a></li>
								<li><a href="#">急售</a></li>
								<li><a href="#">准新车</a></li>
								<li><a href="#">超值</a></li>
								<li><a href="#">直销车</a></li>
							</ul>
						</h3>
					</div>-->
				</div>
				<div class="clear_fix"></div>
			</div>
		</div>
		<div class="menu_r">
			<div class="flexslider">
				<ul class="slides">
					<li style="background-image: url(resource/images/1.jpg);"></li>
					<li style="background-image: url(resource/images/2.jpg);"></li>
					<li style="background-image: url(resource/images/3.jpg);"></li>
					<li style="background-image: url(resource/images/4.jpg);"></li>
				</ul>
			</div>
			<div class="clear_fix"></div>
			<div class="purpose">
				<div class="ind-dz-lc">
					<ul>
						<li>
							<div class="circle radius">
								<i class="lc-01"></i>
							</div>
							<div class="txt">
								<h4>一年/两万公里质保</h4>
							</div>
						</li>
						<li>
							<div class="circle radius">
								<i class="lc-02"></i>
							</div>
							<div class="txt">
								<h4>全面检测</h4>
							</div>
						</li>
						<li>
							<div class="circle radius">
								<i class="lc-03"></i>
							</div>
							<div class="txt">
								<h4>14天可退</h4>
							</div>
						</li>
						<li>
							<div class="circle radius">
								<i class="lc-04"></i>
							</div>
							<div class="txt">
								<h4>品牌优惠</h4>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.flexslider').flexslider({
				directionNav : true,
				pauseOnAction : false
			});
			$('.flexslider').hover(function() {
				$('.flex-direction-nav').fadeIn();
			}, function() {
				$('.flex-direction-nav').fadeOut();
			})
		});
	</script>

	<!--车类列表-->
	<div class="car_feature">


		<div class="menucarlist fr">
			<div id="divs2_0">
				<ul class="carList">


				</ul>
			</div>

		</div>
	</div>

	<div class="clear_fix"></div>
	<!--底部-->
	<div class="ftWrap">
		<div class="foot">
			<div class="cent">
				<div class="relate">
					<div class="items">
						<div class="tit">
							<i class="icon-angle-right"></i>交易帮助
						</div>
						<div class="con">
							<a href="#">买车帮助</a> <a href="#">卖车帮助</a> <a href="#">过户帮助</a>
						</div>
					</div>
					<div class="items">
						<div class="tit">
							<i class="icon-angle-right"></i>客服中心
						</div>
						<div class="con">
							<a href="abut.html">网站合作</a> <a href="about.html">关于我们</a> <a
								href="contact.html">联系我们</a>
						</div>
					</div>
					<div class="items">
						<div class="tit">
							<i class="icon-angle-right"></i>购车指南
						</div>
						<div class="con">
							<a href="#">购车帮助</a>
						</div>
					</div>
					<div class="app-section">
						<img class="js-delayed-img" src="resource/images/f_wx.jpg">
						<div class="title">扫码关注微信</div>
						<p>
							随时随地，秒杀好车<br /> 优质个人二手车
						</p>
					</div>
					<div class="items last">
						<div class="tel">
							<h1>400-877-9288</h1>
							<p>周一至周日 8:00-18:00</p>
							<p>免费咨询(咨询、建议、投诉)</p>
							<a href="#" class="kf"><i class="kf-icon"></i>在线客服</a>
						</div>
						<div class="tel-mb">
							<p>
								<span>400-710-8886</span>周一至周日 8:00-18:00(仅收市话费)
							</p>
							<a href="#" class="kf"><i class="kf-icon"></i>在线客服</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="cent">Copyright © 2016-2017, snncar.com,All Rights
				Reserved 皖ICP备16022456号-1</div>
		</div>
	</div>
	<div id="leftsead">
		<ul>
			<li><a id="guestbook"><img
					src="resource/images/foot03/II101.jpg" width="47" height="49"
					class="show" /> </a></li>
			<li><a id="top_btn"> <img
					src="resource/images/foot03/ll06.png" width="47" height="49"
					class="hides" /> <img src="resource/images/foot03/l06.png"
					width="47" height="49" class="shows" />
			</a></li>

			<li><a href=""> <img src="resource/images/foot03/ll02.png"
					width="166" height="49" class="hides" /> <img
					src="resource/images/foot03/l04.png" width="47" height="49"
					class="shows" />
			</a></li>

			<li><a class="youhui"> <img
					src="resource/images/foot03/l02.png" width="47" height="49"
					class="shows" /> <img src="resource/images/foot03/zfew.jpg"
					width="196" height="205" class="hides" usemap="#taklhtml" />
			</a></li>

		</ul>
	</div>
</body>

</html>