<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<title>阳光好车</title>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/resource/images/title.jpg"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/frontEnd/base.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/frontEnd/home.css" />
		<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/home_ban.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/eg_top_search.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/snncar.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/scrollBar.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/item/itemInfo.js"></script>
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
				
				
				<div class="hot-phone"> <i></i> <span class="js-change-phone">400-877-9288</span> </div>
			</div>
		</div>
		<ul class="navmenu">
			<li class="active">
				<a href="index">首页</a><span></span>
			</li>
			<li><a href="itemList" data-item-id='1' id='itemList'>我要买车</a><span></span></li>
			<li><a href="itemListFitting" id='itemListFitting' data-item-id='2'>购买配件</a><span></span></li>	
			<li>
				<a id="memberCenter" href="memberCenter">会员中心</a><span></span>
			</li>
			<li>
				<a href="getGuestBook">查看留言</a><span></span>
			</li>
		</ul>
		<div class="clear_fix"></div>
		<!--所在位置-->
		<div class="crumbp">
			<a href="index">首页</a> <em>&gt;</em> <span>车辆详情</span></div>
		<div class="mainbox">
			<!--车子概况头部-->
			<div class="car-top">
				<div class="row">
					<div class="mainpic"> 
					</div>
					<div class="carinfor">
						<h3 class="car-allname"></h3>
						<div class="price-box">
							<div class="price-infor">
								<p><span class="nowprice"></span></p>
							</div>
							
						</div>
						<div class="clear_fix"></div>
						<div class="item-box">
							<div class="itemlist rightline">
								<p class="text-muted">品牌</p>
								<p id='brand'></p>
							</div>
							<div class="itemlist rightline">
								<p class="text-muted">车系</p>
								<p id='series'></p>
							</div>
						</div>
						<div class="row">
							<div class="tel-box"> 电话咨询 :<em>400-877-9388</em> </div>
							
							
						</div>
						<!--优势-->
						<div class="advantage">
							<h3>阳光好车已对该车辆进行检测，并将提供售后服务及保障。</h3>
							<div class="ind-dz-lc">
								<ul>
									<li>
										<div class="circle radius"> <i class="lc-01"></i> </div>
										<div class="txt">
											<h4>一年/两万公里质保</h4>
										</div>
									</li>
									<li>
										<div class="circle radius"> <i class="lc-02"></i> </div>
										<div class="txt">
											<h4>全面检测</h4>
										</div>
									</li>
									<li>
										<div class="circle radius"> <i class="lc-04"></i> </div>
										<div class="txt">
											<h4>100%个人车源</h4>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--详细导航-->
			<div class="cont-tips-outer" id="J_m_nav">
				<div class="cont-tips">
					
					<ul class="cont-tips-qh clearfix">
						
						<li>
							<a href="#base" rel="nofollow">车辆信息</a>
						</li>
						<li>
							<a href="#picture" rel="nofollow">车辆图片</a>
						</li>
						
					</ul>
				</div>
			</div>
			
			<div id="base">
				<!--基本信息-->
				<div class="titles">
					<h2>车辆信息</h2>
				</div>
				<div class="ca-table">
					<table>
					
					</table>
				</div>
			</div>
			<div id="picture">
				<!--车俩图片-->
				<div class="titles">
					<h2>车俩图片</h2>
				</div>
				<ul class="carpiclist">
					
					
				</ul>
				<div class="clear_fix"></div>
				
				
			</div>
		</div>

		<div class="clear_fix"></div>
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