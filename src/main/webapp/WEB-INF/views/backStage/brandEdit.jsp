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
<link rel="shortcut icon" href="resource/images/title.jpg" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="<%=request.getContextPath()%>/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/assets/css/ace.min.css" />
<link type="text/css" href="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="<%=request.getContextPath()%>/resource/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/Plugs/jqueryform/jquery.form.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/js/typeahead-bs2.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/Plugs/toastr/toastr.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/backStage/brand/brandEdit.js"></script>
</head>

<body>
	<div class=" clearfix" style="widows: 100%; height: 100%">
		<div id="add_brand" class="clearfix">
		<form action="#" method="post" id="brand_edit_form">
			<div class="left_add">
				<ul class="add_conent">
					<li class=" clearfix"><label class="label_name"><i>*</i>品牌名称：</label>
					<input type="hidden" name="itemSeriesID" value="${itemSeries.itemSeriesID }">
						<input name="itemBrandName" type="text" class="add_text"
						value="${ itemSeries.itemBrand.itemBrandName}" /></li>

					<li class=" clearfix"><label class="label_name"><i>*</i>所属地区：</label>
						<input name="itemBrandCity" type="text" class="add_text"
						value="${ itemSeries.itemBrand.itemBrandCity}" /></li>
					<li class=" clearfix"><label class="label_name"><i>*</i>创立时间：</label>
						<input name="createTime" type="text" class="add_text"
						value="${ itemSeries.itemBrand.createTime}" /></li>
					<li class=" clearfix li"><label class="label_name"><i>*</i>旗下系列：</label>
						<input name="itemSeriesName" type="text" class="add_text"
						value="${ itemSeries.itemSeriesName}" /></li>
				</ul>
			</div>
			<div class="button_brand">
				<input name="" type="submit" class="btn btn-warning" value="保存" />
			</div>
		</form>
		</div>
	</div>
</body>
</html>
