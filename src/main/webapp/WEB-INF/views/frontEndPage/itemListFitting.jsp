<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>阳光好车</title>
<link rel="shortcut icon" href="resource/images/title.jpg" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/base.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/home.css" />
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/assets/js/jquery-2.0.3.min.js"></script>

<script type="text/javascript" src="resource/js/frontEnd/home_ban.js"></script>
<script type="text/javascript" src="resource/js/Plugs/eg_top_search.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/snncar.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/scrollBar.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/bootstrap/3.3.6/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/bootstrap/3.3.6/bootstrap-paginator.js"></script>
<script
	src="<%=request.getContextPath()%>/resource/assets/layer/layer.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/index.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/item/itemListFitting.js"></script>
	<style type="text/css">
#page li{
            cursor:pointer;
        }
</style>
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

			<div class="sea">
				<div class="egc-sea-box">
					<input type="text" class="sea-ipt-txt" placeholder="搜索您想要的车" /> <a
						href="javascript:void(0)" id="search-btn" class="search-btn">搜索</a>
				</div>
			</div>
			<div class="hot-phone">
				<i></i> <span class="js-change-phone">400-877-9288</span>
			</div>
		</div>
	</div>
	<ul class="navmenu">
		<li class="active"><a href="index">首页</a><span></span></li>
		<li><a href="itemList" data-item-id='1' id='itemList'>我要买车</a><span></span></li>
		<li><a href="itemListFitting" id='itemListFitting' data-item-id='2'>购买配件</a><span></span></li>
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
				<li class="active"><a href=" index">首页</a><span></span></li>
				<li><a href="itemList" data-item-id='1' id='itemList'>我要买车</a><span></span></li>
				<li><a href="itemListFitting" id='itemListFitting' data-item-id='2'>购买配件</a><span></span></li>
				<li><a href="memberCenter">会员中心</a><span></span></li>
				<li><a href="getGuestBook">查看留言</a><span></span></li>
			</ul>
			<div class="seas">
				<div class="egc-sea-box">
					<input type="text" class="sea-ipt-txt" placeholder="搜索您想要的车">
					<a href="javascript:void(0)"  id="search-btns" class="search-btn">搜索</a>
				</div>
			</div>
		</div>
	</div>
	<div class="clear_fix"></div>
	<!--所在位置-->
	<div class="crumbp">
		<a href="index">首页</a> <em>&gt;</em> <span>资源好车</span>
	</div>
	<div class="mainbox">
		<!--搜索条件-->
		<div class="comfilter-bd">
			<div class="filterBox">
				<dl class="fliter-bd clearfix">
					<dt>品牌：</dt>
					<dd class="clickBrandWidget" id='brand'>
						<a class="on" href="#">不限</a>

						<!--品牌全部-->
						<span class="brand-all z30"> <em data-role="show" style="display: none">全部<i></i></em>
							<div data-role="otherBrand" class="otherbrand"
								style="display: none;">
								<div class="o-b-box">
									<ul data-role="letterNav" id='ul' class="o-b-list">

									</ul>
								</div>
							</div>
						</span>
						<!--品牌全部-->
						<!--品牌全部-->
					</dd>
				</dl>
				<dl class="fliter-bd clearfix" id="carSeries">
					<dt>车系：</dt>
					<dd class="clickTagWidget">
						<a class="on" href="javascript:void(0)">不限</a>
					</dd>
				</dl>
			</div>
			
		</div>
		
		<ul class="carList">
			
		</ul>
	</div>
	<div class="container" style="text-align: center;">
        <div style="margin-top: 20px;">
            <ul id="page"></ul>
        </div>
    </div>	<div class="clear_fix"></div>
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
							<a href="javascript:void(0)">买车帮助</a> <a
								href="javascript:void(0)">卖车帮助</a> <a href="javascript:void(0)">过户帮助</a>
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
							<a href="javascript:void(0)">购车帮助</a>
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
							<a href="javascript:void(0)" class="kf"><i class="kf-icon"></i>在线客服</a>
						</div>
						<div class="tel-mb">
							<p>
								<span>400-710-8886</span>周一至周日 8:00-18:00(仅收市话费)
							</p>
							<a href="javascript:void(0)" class="kf"><i class="kf-icon"></i>在线客服</a>
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


	<script>
		$(function() {
			var t = null, $this, i = 0;
			//品牌
			$(".brand-all").bind({
				mouseenter : function() {
					$(this).find(".otherbrand").show();
				},
				mouseleave : function() {
					$(this).find(".otherbrand").hide();
				}
			});

		});
	</script>
	<script type="text/javascript">
		$(".hoverWidget").each(function() {
			$(this).mouseenter(function() {
				$(this).addClass("active")
			}).mouseleave(function() {
				$(this).removeClass("active")
			})
		});
	</script>
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
					width="196" height="205" class="hides"
					usemap="javascript:void(0)taklhtml" />
			</a></li>

		</ul>
	</div>
	


	
</body>

</html>