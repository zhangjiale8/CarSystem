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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/base.css" />
	<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/style.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/home.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/frontEnd/hurst.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
	<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/datatables/css/dataTablePage.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<script type="text/javascript"
	src="resource/js/Plugs/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/home_ban.js"></script>
<script type="text/javascript" src="resource/js/Plugs/eg_top_search.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/snncar.js"></script>
<script type="text/javascript" src="resource/js/frontEnd/scrollBar.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/datatables/js/jquery.dataTables.evm.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/index.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/userName.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/item/memberCenter.js"></script>

</head>

<body>
	<!--Begin Header Begin-->

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
			<div class="logos">
				<a href="index"><img src="resource/images/logo.png" width="240" /></a>
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
	<!--End Header End-->
	<div class="i_bg bg_color">
		<!--Begin 用户中心 Begin -->
		<div class="m_content">
			<div class="m_left">
				<div class="left_n">管理中心</div>
				<div class="left_m">
					<div class="left_m_t t_bg1">订单中心</div>
					<ul>
						<li><a href="javaScript:void(0)" id="orders">交易订单</a></li>
						<li><a href="javaScript:void(0)" id="lookOrder">预约订单</a></li>

					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg2">会员中心</div>
					<ul>
						<li><a href="javaScript:void(0)" id="user">个人信息</a></li>
						
						<li><a href="javaScript:void(0)" id="userInfo">修改信息</a></li>

					</ul>
				</div>


			</div>
			<div class="m_right" id="order" >
				<p></p>
				<div class="mem_tit">交易订单</div>
				<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th ><label><input type="checkbox" id="itemOrder_checkbox"
										class="ace"><span class="lbl"></span></label></th>
								
								<th >订单号</th>
								<th >商品编号</th>
								<th >商品类型</th>
								<th >商品名称</th>
							<!-- <th >商品颜色</th> -->
								<th >订单数量</th>
								<th >商品总价</th>
								
								<th>客户名称</th>
								
								<th >日期</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>

					</table>
			</div>
			<div class="m_right" id="look" style="display:none;">
				<p></p>
				<div class="mem_tit">预约订单</div>
				<table class="table table-striped table-bordered table-hover"
						id="sample-tables">
						<thead>
							<tr>
								<th ><label><input type="checkbox" id="lookCarOrder_checkbox"
										class="ace"><span class="lbl"></span></label></th>
								
								<th >商品编号</th>
								<th >商品类型</th>
								<th >商品名称</th>
								<th >商品型号</th>
								<th >商品颜色</th>
								<th >商品单价</th>
								<th>客户名称</th>
								<th>联系方式</th>
								<th >预约日期</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>

					</table>
			</div>
		</div>
	</div>
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
	
</body>

</html>
