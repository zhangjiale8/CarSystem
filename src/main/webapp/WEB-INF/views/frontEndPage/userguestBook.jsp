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
	src="<%=request.getContextPath()%>/resource/js/frontEnd/guestbook/usergustbook.js"></script>
<style>
        #page li{
            cursor:pointer;
        }
    </style>
</head>
<body>
	
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