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
<title>添加品牌</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resource/images/title.jpg" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link
	href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.css" />
	
<script
	src="<%=request.getContextPath()%>/resource/js/jquery-1.9.1.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.min.js" type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resource/assets/layer/layer.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/backStage/brand/addBrand.js"></script>
</head>

<body>
	<div class=" clearfix" style="widows: 100%; height: 100%">
		<div id="add_brand" class="clearfix">
			<div class="left_add" style="margin-top: 5px">
				<ul class="add_conent">
					<li class=" clearfix"><label class="label_name"><i>*</i>品牌名称：</label>
						<input name="" type="text" id="itemBrandName" class="add_text" /></li>

					<li class=" clearfix"><label class="label_name"><i>*</i>所属地区：</label>
						<input name="" type="text" id="address" class="add_text" /></li>
					<li class=" clearfix"><label class="label_name"><i>*</i>成立时间：</label>
						<input name="" type="text" id="time" class="add_text" /></li>
					<li class=" clearfix li"><label class="label_name"><i>*</i>旗下系列：</label>
						<input name="" type="text" id="seriesName" class="add_text" /> <a
						href="#" id="addInput" style="margin-left: 5px; margin-top: 5px;">

					</a></li>


				</ul>
			</div>

			<div class="button_brand" style="margin-bottom: 5px;">
				<input name="" type="button" id="submit" class="btn btn-warning"
					value="保存" /><input name="" type="reset" value="取消" id="rest"
					class="btn btn-warning" />
			</div>
		</div>
	</div>
</body>
</html>
