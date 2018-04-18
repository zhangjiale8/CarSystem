<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>留言板</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resource/css/frontEnd/guestBook.css">
<link type="text/css"
	href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="resource/js/Plugs/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/frontEnd/guestbook/addGuestBook.js"></script>

</head>
<body>
	<!-- 下面实现留言板功能 -->
	<div class="mainframe">
		<div class="title">留言板</div>

		<div class="info">请给我们留下宝贵的意见或建议~</div>
		<div class="content" contenteditable="true"></div>
		<input type="button" name="submit" value="发表" class="subbtn">
		<div class="numofmessage">留言(0)</div>
		<!-- 下面是留言区 -->
		<div class="msgFrame"></div>
	</div>

</body>


</html>