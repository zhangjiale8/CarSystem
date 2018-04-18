<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resource/images/title.jpg" />
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<script src="<%=request.getContextPath()%>/resource/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/laydate/laydate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resource/js/backStage/item/guestBook/guestBookEdit.js"
	type="text/javascript"></script>
	<style type="text/css">
	
	.form-group {
	text-align: center;
	}
	</style>
<title>留言编辑</title>
</head>
<body>
	<div id="Guestbook">
		<div class="content_style" >
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-field-1">留言用户 </label>
				<div class="col-sm-9">${guestBook.userName}</div>
				<input  name="guestBookID" style="display: none" id="guestBookID" value="${guestBook.guestBookID }"/>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-field-1"> 留言内容 </label>
				<div class="col-sm-9">${guestBook.guestBookContent }</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-field-1">是否回复 </label>
				<div class="col-sm-9">
					<label><input name="checkbox" type="checkbox" class="ace"
						id="checkbox"><span class="lbl"> 回复</span></label>
					<div class="Reply_style">
						<textarea name="权限描述" class="form-control" id="form_textarea"
							placeholder="" onkeyup="checkLength(this);">${guestBook.replyContent}</textarea>
						<span class="wordage">剩余字数：<span id="sy"
							style="color: Red;">200</span>字
						</span>
					</div>
				</div>
			</div>
			<div class="form-group" style="margin-top: 50px">
				<a href="javascript:void(0)"
					id="submit" class="btn btn-warning">确定</a>
					<a href="javascript:void(0)" id="rest" class="btn btn-success"></i>取消</a>
			</div>
		</div>
	</div>
</body>
</html>