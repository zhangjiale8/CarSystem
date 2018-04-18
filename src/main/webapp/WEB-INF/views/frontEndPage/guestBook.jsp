<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>阳光好车</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resource/css/frontEnd/allGuestBook.css">
<link type="text/css"
	href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/base.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/home.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/assets/js/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/bootstrap/3.3.6/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/bootstrap/3.3.6/bootstrap-paginator.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/snncar.js"></script>
<script type="text/javascript" src="resource/js/Plugs/eg_top_search.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/guestbook/gustbook.js"></script>
<style>
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
						href="#" class="search-btn">搜索</a>
				</div>
			</div>
			<div class="hot-phone">
				<i></i> <span class="js-change-phone">400-877-9288</span>
			</div>
		</div>
	</div>
	<ul class="navmenu">
		<li class="active"><a href="index">首页</a><span></span></li>
		<li><a href="itemList">我要买车</a><span></span></li>
		<li><a href="itemList">购买配件</a><span></span></li>
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
				<li><a href="itemList">我要买车</a></li>
				<li><a href="itemList">购买配件</a></li>
				<li><a href="memberCenter">会员中心</a></li>
				<li><a href="getGuestBook">查看留言</a></li>

			</ul>
			<div class="seas">
				<div class="egc-sea-box">
					<input type="text" class="sea-ipt-txt" placeholder="搜索您想要的车">
					<a href="#" class="search-btn">搜索</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 下面实现留言板功能 -->
	<div class="mainframe">
		<div class="title">留言板</div>
		<!-- 下面是留言区 -->
		<div class="msgFrame"></div>
	</div>
	<div class="container" style="text-align: center;">
        <div style="margin-top: 20px;">
            <ul id="page"></ul>
        </div>
    </div>
</body>
<script type="text/javascript">
   
</script>

</html>