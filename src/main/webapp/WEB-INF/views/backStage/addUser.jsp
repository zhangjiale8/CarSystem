<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/evm_frame.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/evm_elements.css" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="<%=request.getContextPath()%>/resource/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/jqueryform/jquery.form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/md5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/validate/jquery.validate.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/backStage/user/addUser.js"></script>
<style>
.form {
	display: inline-block;
	position: absolute;
	top: 35%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
<title>管理员</title>
</head>

<body>

	<!--添加管理员-->
	<div class="form">
		<form action="#" method="post" id="user_add_form">
			<ul class='attributes'>
				
				<li class='attribute'>
					<div class='name'>用户名:</div>
					<div class='value'>
						<input type="text" name="userName" class="w268"
							data-rule-required="true" />
					</div>

					<div class='name'>姓名:</div>
					<div class='value'>
						<input type="text" name="userShowName" class="w268"
							data-rule-required="true" />
					</div>
				</li>
				<li class='attribute'>
					<div class='name'>密码:</div>
					<div class='value'>
						<input type="password" name="userPassWord" class="w268 userPwd"
							data-rule-required="true" />
					</div>

					<div class='name'>再次输入密码:</div>
					<div class='value'>
						<input type="password" name="userPasswordAgain"
							class="w268 userPwdAgain" data-rule-required="true" />
					</div>
				</li>

				<li class='attribute'>
					

					<div class='name'>手机:</div>
					<div class='value'>
						<input type="text" name="userPhone" class="w268"
							data-rule-required="false" />
					</div>
				</li>
				
				<li class='attribute'>
					<div class='name'>状态:</div>
					<div class='value'>
						<input type="radio" name="state" checked="checked" id="enable" value="1" /><label
							for="enable">启用</label> <input type="radio" name="state"
							id="disable" value="2" /><label for="disable">禁用</label>
					</div>
				</li>
				

				<li class='attribute'>
					<div class='name'></div>
					<div class='value'>
						<button type="submit">提交</button>
					</div>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>