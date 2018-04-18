<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阳光好车</title>
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/css.css" />
<link rel="shortcut icon" href="resource/images/title.jpg" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/base.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/home.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/hurst.css" />
<script type="text/javascript"
	src="resource/js/Plugs/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/home_ban.js"></script>
<script type="text/javascript" src="resource/js/Plugs/eg_top_search.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/snncar.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/scrollBar.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>

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
		<li><a href="itemList" data-item-id='1' class='itemList'>我要买车</a><span></span></li>
		<li><a href="itemList" class='itemList' data-item-id='2'>购买配件</a><span></span></li>
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
				<li><a href="getGuestBook">查看留言</a><span></span></li>
			</ul>

		</div>
	</div>
	<div class="Caddress">
		<div class="open_new">
			<button class="open_btn">使用新地址</button>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
	</div>

	<div class="shopping_content">
		<div class="shopping_table">
			<table border="1" bordercolor="#cccccc" cellspacing="0"
				cellpadding="0" style="width: 100%; text-align: center;">
				<tr>
					<th>商品图片</th>
					<th>商品名称</th>
					<th>商品属性</th>
					<th>商品价格</th>
					<th>商品数量</th>
					<th>商品操作</th>
				</tr>
				<tr>
					<td><a><img src="images/2f1.jpg" /></a></td>
					<td><span>小消息下</span></td>
					<td>
						<div class="">
							<span id="">颜色</span>：<span>白色</span>
						</div>
						<div class="">
							<span id="">尺码</span>：<span>L</span>
						</div>
					</td>
					<td><span class="span_momey">11.10</span></td>
					<td>
						<button class="btn_reduce"
							onclick="javascript:onclick_reduce(this);">-</button> <input
						class="momey_input" type="" name="" id="" value="1"
						disabled="disabled" />
						<button class="btn_add" onclick="javascript:onclick_btnAdd(this);">+</button>
					</td>
					<td>
						<button class="btn_r" onclick="javascript:onclick_remove(this);">删除</button>
					</td>
				</tr>

			</table>
			<div class=""
				style="width: 100%; text-align: right; margin-top: 10px;">
				<div class="div_outMumey" style="float: left;">
					总价：<span class="out_momey">11</span>
				</div>
				<button class="btn_closing">结算</button>
			</div>
		</div>
	</div>
	<!--底部-->
		<div class="ftWrap">
			<div class="foot">
				<div class="cent">
					<div class="relate">
						<div class="items">
							<div class="tit"><i class="icon-angle-right"></i>交易帮助</div>
							<div class="con">
								<a href="#">买车帮助</a>
								<a href="#">卖车帮助</a>
								<a href="#">过户帮助</a>
							</div>
						</div>
						<div class="items">
							<div class="tit"><i class="icon-angle-right"></i>客服中心</div>
							<div class="con">
								<a href="abut.html">网站合作</a>
								<a href="about.html">关于我们</a>
								<a href="contact.html">联系我们</a>
							</div>
						</div>
						<div class="items">
							<div class="tit"><i class="icon-angle-right"></i>购车指南</div>
							<div class="con">
								<a href="#">购车帮助</a>
							</div>
						</div>
						<div class="app-section"> <img class="js-delayed-img" src="resource/images/f_wx.jpg">
							<div class="title">扫码关注微信</div>
							<p> 随时随地，秒杀好车<br /> 优质个人二手车 </p>
						</div>
						<div class="items last">
							<div class="tel">
								<h1>400-877-9288</h1>
								<p>周一至周日 8:00-18:00</p>
								<p>免费咨询(咨询、建议、投诉)</p>
								<a href="#" class="kf"><i class="kf-icon"></i>在线客服</a>
							</div>
							<div class="tel-mb">
								<p><span>400-710-8886</span>周一至周日 8:00-18:00(仅收市话费)</p>
								<a href="#" class="kf"><i class="kf-icon"></i>在线客服</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="copyright">
				<div class="cent"> Copyright © 2016-2017, snncar.com,All Rights Reserved 皖ICP备16022456号-1</div>
			</div>
		</div>
		
		<script type="text/javascript">
			$(".appearance-det").each(function() {
				$(this).mouseenter(function() {
					$(this).addClass("active")
				}).mouseleave(function() {
					$(this).removeClass("active")
				})
			});
		</script>
		
		
		
		<script type='text/javascript'>
			var nt = !1;
			$(window).bind("scroll",
				function() {
					var st = $(document).scrollTop(); //往下滚的高度
					nt = nt ? nt : $("#J_m_nav").offset().top;
					var sel = $("#J_m_nav");
					if(nt < st) {
						sel.addClass("nav_fixeds");
					} else {
						sel.removeClass("nav_fixeds");
					}
				});
		</script>
		<script type="text/javascript">
			$(function() {
				$(".cont-tips-qh li").click(function() {
					$(this).siblings('li').removeClass('active'); // 删除其他兄弟元素的样式
					$(this).addClass('active'); // 添加当前元素的样式
				});
			});
		</script>
		<div id="leftsead">
		<ul>
		<li ><a id="guestbook"><img 
					src="resource/images/foot03/II101.jpg" width="47" height="49"
					class="show" />
			</a></li>
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