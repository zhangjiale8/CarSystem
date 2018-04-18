<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
   <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>阳光好车</title>
		<link rel="shortcut icon" href="resource/images/title.jpg"/>
		<link rel="stylesheet" type="text/css" href="resource/css/frontEnd/base.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/frontEnd/home.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/frontEnd/hurst.css" />
		<script type="text/javascript" src="resource/js/Plugs/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="resource/js/frontEnd/home_ban.js"></script>
		<script type="text/javascript" src="resource/js/Plugs/eg_top_search.js"></script>
		<script type="text/javascript" src="resource/js/frontEnd/snncar.js"></script>
		<script type="text/javascript" src="resource/js/frontEnd/scrollBar.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>

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
			<li><a href="itemList" data-item-id='1' class='itemList'>我要买车</a><span></span></li>
				<li><a href="itemList" class='itemList' data-item-id='2'>购买配件</a><span></span></li>
			<li>
				<a href="memberCenter">会员中心</a><span></span>
			</li>
			<li>
				<a href="getGuestBook">查看留言</a><span></span>
			</li>
		</ul>
		<div class="clear_fix"></div>
		<div class="stress-search-box row">
			<div class="stress-close">
				<a href="javascript:;"></a>
			</div>
			<div class="nav-cents">
				<ul>
					<li class="logo">
						<a href="index"><img src="resource/images/logo.png" width="180" /></a>
					</li>
					<li>
						<a href="index">首页</a>
					</li>
					<li><a href="itemList" data-item-id='1' id='itemList'>我要买车</a><span></span></li>
		<li><a href="itemListFitting" id='itemListFitting' data-item-id='2'>购买配件</a><span></span></li>
					<li>
						<a href="memberCenter">会员中心</a>
					</li>
					<li>
						<a href="getGuestBook">查看留言</a><span></span>
					</li>
				</ul>
				
			</div>
		</div>
		<div class="clear_fix"></div>
		<!--会员中心-->
		<div class="mebBox">
			<div class="meb-cont clearfix mainbox">
				<div class="meb-nav fl dInline">
					<ul class="clearfix">
						<li>
							<a href="memberCenter">会员中心</a>
						</li>
						<li>
							<a href="needs">我的需求</a>
						</li>
						<li class="on">
							<a href="manage">账户管理</a>
						</li>
					</ul>
				</div>
				<div class="meb-right fr dInline">
					<div class="mr-top">
						<div class="mr-top-div clearfix">
							<span class="fl">
            <img src="resource/images/photo.png">
        </span>
							<div class="mr-infor fl dInline">
								<h2>中午好，尊敬的会员 <b>朱先生</b></h2>
								<p>
									手机：15138911875 邮箱： | [
									<a href="#">管理账户信息</a> ]
								</p>
							</div>
						</div>
					</div>
					<div class="mr-detail">
						<div class="mr-tab clearfix">
							<a class="on">个人资料管理 </a>
							<a>修改密码</a>
						</div>
						<div class="me-box me-box1">
							<div class="me-dl" style="display:block;">
								<div class="me-one">
									<div class="accForm">
										<form action="" enctype="multipart/form-data" name="editM" method="post" onsubmit="return checkpost();">
											<div class="afl clearfix">
												<label class="fl">
												手机号码
											</label>
												<div class="af-r fl dInline">
													<input type="text" class="ar-txt" name="mobile" placeholder="请输入手机号码" value="15138911875" disabled="disabled">
												</div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
												姓名
											</label>
												<div class="af-r fl dInline">
													<input type="text" class="ar-txt" name="realname" placeholder="请输入您的姓名" value="董平运">
												</div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
												性别
											</label>
												<div class="af-r fl dInline">
													<span>
													<input type="radio" name="gender" value="M"> 男
												</span>
													<span>
													<input type="radio" name="gender" checked="" value="F"> 女
												</span> </div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
												邮箱
											</label>
												<div class="af-r fl dInline">
													<input type="text" class="ar-txt" name="email" placeholder="请输入您的邮箱" value="">
												</div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
											</label>
												<div class="af-r fl dInline">
													<input type="submit" value="提 交" class="ar-btn">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="me-dl" style="display:none;">
								<div class="me-one">
									<div class="accForm">
										<form action="" enctype="multipart/form-data" name="editP" method="post" onsubmit="return checkPasspost();">
											<div class="afl clearfix">
												<label class="fl">
												当前密码
											</label>
												<div class="af-r fl dInline">
													<input type="password" class="ar-txt" name="password" placeholder="请输入当前密码" value="">
												</div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
												新密码
											</label>
												<div class="af-r fl dInline">
													<input type="password" class="ar-txt" name="password1" placeholder="请输入新密码" value="">
												</div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
												确认新密码
											</label>
												<div class="af-r fl dInline">
													<input type="password" class="ar-txt" name="password2" placeholder="请确认输入的新密码" value="">
												</div>
											</div>
											<div class="afl clearfix">
												<label class="fl">
											</label>
												<div class="af-r fl dInline">
													<input type="submit" value="提 交" class="ar-btn">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
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
								<a href="#">网站合作</a>
								<a href="#">关于我们</a>
								<a href="#">联系我们</a>
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
		<script type="text/javascript" src="script/3c-menu.js"></script>
		<script type="text/javascript" src="script/lg_reg.js"></script>


	</body>

</html>