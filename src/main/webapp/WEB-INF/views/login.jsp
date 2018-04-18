<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<title>登录阳光好车</title>
		<link rel="shortcut icon" href="resource/images/title.jpg"/>
		<link rel="stylesheet" href="resource/css/frontEnd/base.css">
		<link rel="stylesheet" type="text/css" href="resource/css/login.css">
		<script src="resource/js/jquery-1.9.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
		<script type="text/javascript" src="resource/js/frontEnd/login.js"></script>
	</head>

	<body>
		<!-- **************头部页面开始****** -->
		<div class="w">
			<div id="logo">
				<a href="index.html">
					<img src="resource/images/logo.png" alt="">
				</a>
				<b></b>
			</div>

		</div>
		<!-- ************头部页面结束********** -->
		<div id="content">
			<!-- login-wrapk开始 -->
			<div class="login-wrap">
				<!-- w开始 -->
				<div class="w">
					<!-- *****************登录页面开始************ -->
					<div class="login-form">

						<div class="login-tab login-tab-r">
							<a href="javascript:;">账号登录</a>
						</div>
						<!-- login-box开始（账户登录） -->
						<div class="login-box" style="visibility: visible; display:block">
							<div class="mt tab-h"></div>
							<!-- 登录提示信息开始 -->
							<div class="msg-wrap">

								<div class="msg-error hide">
									<b></b>
								</div>
							</div>
							<!-- 登录提示信息结束 -->
							<div class="mc">
								<div class="form">
									<form action="doLogin"  method="post" id="login_form">
										
										<!-- 用户名输入框fore1 -->
										<div class="item item-fore1 item-error">
											<label for="loginname" class="login-label name-label"></label>
											<input type="text" name="userName" id="userName" class="itxt" tabindex="1" autocomplete="off" placeholder="用户名">
											<span class="clear-btn" style="display:inline;"></span>
										</div>
										<!-- 密码输入框fore2 -->
										<div id="entry" class="item item-fore2" style="visibility: visible">
											<label class="login-label pwd-label" for="nloginpwd"></label>
											<input type="password" name="userPassWord" id="userPassWord"  class="itxt itxt-error" tabindex="2" autocomplete="off" placeholder="密码">
											<span class="clear-btn" style="display: inline;"></span>
											<span class="capslock" style="display: none;">
				  			  					<b></b>
				  			  					大小写锁定已打开
				  			  				</span>
										</div>

										<!-- 自动登录开始fore4 -->
										<div class="item item-fore4">
											<div class="safe">
												<span>
				                        			<a href="toRegister" target="_blank" class="">
							  							<b></b>立即注册
							  						</a>
			                        			</span>
												<span class="forget-pw-safe">
				                        			<a href="JavaScript:void(0)" id="pass">修改密码</a>
				                        		</span>
											</div>
										</div>
										
										<div class="loginInfo">
											<c:if test="${param.loginInfo != null}">
												<c:out value="${param.loginInfo}"></c:out>
											</c:if>
										</div>
										<!-- 登录按钮开始 -->
										<div class="item item-fore5">
											<div class="login-btn">
												<button type="submit" class="btn-img btn-entry"  id="loginsubmit">
												登&nbsp;&nbsp;&nbsp;&nbsp;录
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<!-- mc结束 2input+自动登录+登录按钮-->

						</div>

					</div>
					<!-- ************ 登录页面login-form结束************  -->
				</div>
				<!-- w结束 -->
				<!-- 中间广告部分开始 -->
				<div class="login-banner" style="background-color: #C00001">
					<div class="w">
						<div id="banner-bg" class="i-inner" style="background: url(resource/images/login/timg.jpg) no-repeat;"></div>
					</div>
				</div>
				<!-- 中间背景广告结束 -->
			</div>
			<!-- login-wrap结束 -->
		</div>
		<!-- 内容部分结束 -->

	</body>
	<script type="text/javascript">
	$(function(){
		
		$("#login_form").submit(function(){
			var username = $.trim($("#userName").val());
			var password = $.trim($("#userPassWord").val());
			
			if(username == "" || password == ""){
				$(".loginInfo").text("用户名或密码不正确");
				return false;
			}
			
			
		});
		
	});
	</script>
</html>