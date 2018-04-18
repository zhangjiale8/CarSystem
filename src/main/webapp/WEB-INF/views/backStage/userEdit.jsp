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
<title>用户修改</title>
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
	src="<%=request.getContextPath()%>/resource/js/backStage/user/userEdit.js"></script>
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

	<div class="form">
		<form action="#" method="post" id="user_edit_form">
			<ul class='attributes'>
				
				<li class='attribute'>
					<div class='name'>用户名:</div>
					<div class='value'>
					<input type="hidden" name="userID" value="${user.userID }">
						<input type="text" name="userName" readonly="readonly" value="${user.userName }" class="w268"
							data-rule-required="true" />
					</div>
				</li>
				<li class='attribute'>
					<div class='name'>姓名:</div>
					<div class='value'>
						<input type="text" name="userShowName" class="w268"
							data-rule-required="true" value="${user.userShowName }"/>
					</div>
				</li>
				

				<li class='attribute'>
					

					<div class='name'>手机:</div>
					<div class='value'>
						<input type="text" name="userPhone" class="w268"
							data-rule-required="false" value="${user.userPhone}"/>
					</div>
				</li>
				
				<li class='attribute'>
					

					<div class='name'>密码:</div>
					<div class='value'>
						<input type="text" name="userPassWord" class="w268"
							data-rule-required="false" value="${user.userPassWord}"/>
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